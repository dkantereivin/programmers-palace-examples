from random import choice
from lib import X, O, clear_console
from board import Board


class Player:
    def __init__(self, human, algorithm):
        self.nodes = {}
        self.human = human
        self.algorithm = algorithm

    def best_move(self, board, maximising=True, depth=0, alpha=-100, beta=100):
        # If this is the main function call and not an iteration.
        is_main_call = depth == 0

        # If this is the main call, the old data will not be relevant to the current board.
        if is_main_call:
            self.nodes.clear()

        # The score of this iteration.
        game_stats = board.game_status()
        if game_stats[0]:
            if game_stats[1] == O:
                return 100 - depth
            elif game_stats[1] == X:
                return - 100 + depth
            else:
                return 0

        current_best = -100 if maximising else 100
        for move_pos in board.available_moves():
            # Clone the list so that modifications don't appear on this copy.
            # Unsure if this applies to python and I'm not taking any chances.
            child_ply_board = Board(board.state.copy())

            # Assuming we're playing as O, we maximise.
            # X if we minimise.
            move_type = self.algorithm if maximising else self.human

            # Maximise/minimise child node by inserting into empty cell.
            child_ply_board.insert(move_type, move_pos)

            # Get the best move using the inverse path with the modified state.
            ply_value = self.best_move(
                child_ply_board, not maximising, depth + 1, alpha, beta
            )

            # Alpha beta pruning.
            if maximising:
                # Update the best value for the move.
                current_best = max(current_best, ply_value)
                alpha = max(alpha, current_best)
            else:
                # Update the worst value for the move.
                current_best = min(current_best, ply_value)
                beta = min(beta, current_best)

            if alpha > beta:
                break

            if is_main_call:
                # Create the moves that will be associated with the rating.
                move = ""
                if ply_value in self.nodes:
                    move = f"{self.nodes[ply_value]},{move_pos}"
                else:
                    move = str(move_pos)

                self.nodes[ply_value] = move

        if is_main_call:
            # Get the move(s) associated with the best rating that was found through iteration.
            move_fetched = self.nodes.get(current_best)
            if "," in move_fetched:
                moves_available = list(map(int, move_fetched.split(",")))
                # Randomly choose an option, as they all progress the game equally in favour of the computer.
                return choice(moves_available)
            else:
                return int(move_fetched)

        # Return the best value for this iteration of available spots.
        return current_best

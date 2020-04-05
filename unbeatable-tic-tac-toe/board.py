from lib import chunks, WINNING_POSSIBILITIES


class Board:
    def __init__(self, state=[1, 2, 3, 4, 5, 6, 7, 8, 9]):
        self.state = state

    def __str__(self):
        created_table = ""
        for row in chunks(self.state, 3):
            line = ""
            for col in list(row):
                line += f"{col}|"
            created_table += f"""{line[:-1]}\n{(len(row) * "--")[:-1]}\n"""
        return created_table.strip().rstrip("-")

    def insert(self, symbol, position):
        if position > 8 or type(self.state[position]) != int:
            return False
        self.state[position] = symbol
        return True

    def available_moves(self):
        move_inds = []
        for ind, pos in enumerate(self.state):
            if type(pos) == int:
                move_inds.append(ind)
        return move_inds

    def is_full(self):
        return all(map(lambda i: type(i) == str, self.state))

    def is_empty(self):
        return all(map(lambda i: type(i) == int, self.state))

    def check_path(self, l1, l2, l3, l4, l5):
        # Checks a path of the provided coordinates.
        return self.state[l1] == self.state[l2] and self.state[l3] == self.state[l4] and type(self.state[l5]) != int

    def game_status(self):
        # Returns (terminal, winner)
        # Winner can be X, O or None.

        # If the board is empty, avoid the iteration process.
        if self.is_empty():
            return (False, None)

        # Check using the coordinates specified in WINNING_POSSIBILITIES if there is a win.
        for win_path in WINNING_POSSIBILITIES:
            # Spread the items fo the tuple as the arguments.
            if self.check_path(*win_path):
                # The last coordinate in the tuple is the winner.
                return (True, self.state[win_path[-1]])

        # If the board is full and none was returned, it is a tie.
        if self.is_full():
            return (True, None)

        # The game continues.
        return (False, None)

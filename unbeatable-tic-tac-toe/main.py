# Written by Oscar Davies... Shameless plug, here is my github: github.com/zorbyte.

from time import sleep
from player import Player
from board import Board
from lib import X, O, Colours, clear_console


def main():
    clear_console()
    turn = X
    board = Board()
    player = Player(X, O)
    while True:
        try:
            stats = board.game_status()
            generated_board_str = str(board)
            print(generated_board_str)
            if stats[0]:
                if stats[1] is None:
                    print("It's a tie!")
                else:
                    print(f"""{stats[1]} won the game!""")
                break
            selected_player_move = 0
            if turn == O:
                # Makes the computer look like an actual player.
                print(f"Enter the position to place {O} >> ")
                selected_player_move = player.best_move(board)
                clear_console()
                print(generated_board_str)
                print(
                    f"Enter the position to place {O} >> {selected_player_move + 1}"
                )
                sleep(1)
            else:
                selected_player_move = int(
                    input(f"Enter the position to place {X} >> ")
                ) - 1

            if not board.insert(turn, selected_player_move):
                print(f"{Colours.YELLOW}Invalid position!{Colours.ENDC}")
                sleep(2)
            else:
                turn = O if turn == X else X
            clear_console()
        except (EOFError, KeyboardInterrupt):
            if turn == X: print("") 
            print("Thanks for playing!")
            break
        except (KeyError, ValueError):
            print("Incorrect input! Try an integer?")


if __name__ == "__main__":
    main()

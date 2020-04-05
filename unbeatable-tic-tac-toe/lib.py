from os import system, name


def clear_console():
    # The clear commands are different for PS/CMD and BASH/ZSH/FISH.
    system("cls" if name == "nt" else "clear")


# Credit for ANSI codes: https://svn.blender.org/svnroot/bf-blender/trunk/blender/build_files/scons/tools/bcolors.py
class Colours:
    PURPLE = "\033[95m"
    BLUE = "\033[94m"
    GREEN = "\033[92m"
    YELLOW = "\033[93m"
    RED = "\033[91m"
    ENDC = "\033[0m"
    BOLD = "\033[1m"
    UNDERLINE = "\033[4m"


def chunks(ls, n):
    # Yield successive n-sized chunks from ls.
    # range(0, 3) -> 0, 1, 2

    for i in range(0, len(ls), n):
        yield ls[i:i + n]


# Constants for X and O.
X = f"{Colours.RED}X{Colours.ENDC}"
O = f"{Colours.GREEN}O{Colours.ENDC}"

WINNING_POSSIBILITIES = (
    # Horizontal possibilities.
    (0, 1, 0, 2, 0),
    (3, 4, 3, 5, 3),
    (6, 7, 6, 8, 6),

    # Vertical possibilities.
    (0, 3, 0, 6, 0),
    (1, 4, 1, 7, 1),
    (2, 5, 2, 8, 2),

    # Diagonal possibilities.
    (0, 4, 0, 8, 0),
    (2, 4, 2, 6, 2)
)

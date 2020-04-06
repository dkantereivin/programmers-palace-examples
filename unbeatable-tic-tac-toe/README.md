# Unbeatable Tic Tac Toe

Contributed by [zorbyte#4500](https://github.com/zorbyte).

## How to run/play.

Make sure you have Python 3.6+ installed (I developed it using that version, so just to stay safe I would recommend using it).

Run `main.py` Type the number you want to place your X on.

## Minimax (using α + β pruning)

### **Definitions**
Ply: A ply is the state of the board once a theoretical move has been made; a node.

Maximising: Making a move in the hopes of winning (The algorithm trying to win).

Minimising: Making a move in the hopes of losing (You trying to win).

Subtree: A branch made in recursion for possible places to put a move.

### **How it works**

The algorithm uses the current board and recusrively checks down each ply by alternating between maximising and minimising. A depth variable which is initialised as 100, is used to tell which path requires less steps to win. To do this, 1 is subtracted from `depth` for each step further down it has to take to win on its subtree. If a subtree results in a loss, the score is multiplied by -1 (thus making it negative) to ensure that the algorithm doesn't choose this path.

To optimise the algorithm a strategy called alpha-beta pruning is employed. Alpha–beta is actually an improved minimax using a heuristic.
It stops evaluating a move when it makes sure that it's worse than previously examined move.

### **Diagram**

> In this example photo, the maximising player is X (the Algorithm) and the minimising player is O (the Player).

![Minimax Diagram](./Diagram.jpg)

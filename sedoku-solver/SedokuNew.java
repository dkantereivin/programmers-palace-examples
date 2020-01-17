# David Kanter Eivin
public class SudokuNew
{
    public static void main(String[] args)
    {
        int[][] sudoku = new int[][] { // test int, this can be changed based on the sudoku board
                {0,0,0,8,0,1,0,0,0},
                {0,0,0,0,0,0,4,3,0},
                {5,0,0,0,0,0,0,0,0},
                {0,0,0,0,7,0,8,0,0},
                {0,0,0,0,0,0,1,0,0},
                {0,2,0,0,3,0,0,0,0},
                {6,0,0,0,0,0,0,7,5},
                {0,0,3,4,0,0,0,0,0},
                {0,0,0,2,0,0,6,0,0}
        };

        SudokuBoard board = new SudokuBoard(sudoku);
        System.out.println(board);
    }
}

class SudokuBoard
{
    private static final int BOARD_LENGTH = 9;
    private int[][] board;

    SudokuBoard(int[][] board)
    {
        this.board = board;
    }


    public String toString()
    {
        String out = "";

        String solvable = this.isSolvable() ? "" : "not ";
        out += "This board is " + solvable + "solvable. The solution is below.\n\n";

        for (int row = 0; row < BOARD_LENGTH; row++)
        {
            if (row % 3 == 0 && row > 0)
                out += "----------------------------------\n";

            for (int col = 0; col < BOARD_LENGTH; col++)
            {
                if (col % 3 == 0 && col > 0)
                    out += " | ";
                out += " " + board[row][col] + " ";
            }
            out += "\n";
        }

        return out;
    }


    private boolean isSolvable()
    {
        for (int row = 0; row < BOARD_LENGTH; row++)
        {
            for (int col = 0; col < BOARD_LENGTH; col++)
            {
                if (board[row][col] == 0)
                {
                    for (int n = 1; n <= 9; n++)
                    {
                        if (tryNum(n, row, col))
                        {
                            board[row][col] = n;
                            if (isSolvable())
                                return true;
                            else
                                board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


    // not a "super inefficient way of testing if a move is valid"
    private boolean tryNum(int key, int row, int col)
    {
        return !(rowContains(row, key) || colContains(col, key) || boxContains(row, col, key));
    }


    // key = number to search for, row = row index
    private boolean rowContains(int row, int key)
    {
        for (int col = 0; col < BOARD_LENGTH; col++)
        {
            if (board[row][col] == key)
                return true;
        }
        return false;
    }


    private boolean colContains(int col, int key)
    {
        for (int row = 0; row < BOARD_LENGTH; row++)
        {
            if (board[row][col] == key)
                return true;
        }
        return false;
    }


    // checks if a 3x3 box contains key
    private boolean boxContains(int row, int col, int key)
    {
        row = row - row % 3;
        col = col - col % 3;

        for (int r = row; r < row + 3; r++)
        {
            for (int c = col; c < col + 3; c++)
            {
                if (board[r][c] == key)
                    return true;
            }
        }
        return false;
    }
}

package test.MyImplementation;

public class MyBacktrackingAlgorithm {
    // it goes element by element (passing through columns first, then rows) and put value (from 1 to 9).
    // With method isValid() it's checking if that value fits in that row, column and box.
    // If the value can be in that field, then we go into
    // recursion with the board that has filled field with value.
    // If the value can't be in that field, then we look if the next value can.
    // We do that until trying every value from 1 to 9 and not one works. That means
    // that some previous step (or steps) before this current was bad (for example in
    // some field we can put 2 or 6 and we put 2. It shows that we can't fill the next
    //empty field in that row because of the bad choice - we should have chosen 6).
    // When this happens, we take a step back (return to the previous field in row)
    // by returning false and then look for different value in that field. If we can't
    //find that value again, then we return to previous field again...
    public static boolean solveBacktracking(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == 0) {
                    for (int value = 1; value <= 9; value++) {
                        board[row][column] = value;
                        if (isValid(board, row, column) && solveBacktracking(board)) {
                            return true;
                        }
                        board[row][column] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isValid(int[][] board, int row, int column) {
        return (isRowValid(board, row,column)
                && isColumnValid(board,row,column)
                && isBoxValid(board, row, column));
    }
    private static boolean isRowValid(int[][] board, int row, int column) {
        for (int col = 0; col < 9; col++) {
            if (col!=column && board[row][col]==board[row][column]) {
                return false;
            }
        }
        return true;
    }
    private static boolean isColumnValid(int[][] board, int row, int column) {
        for (int r = 0; r < 9; r++) {
            if (r!=row && board[r][column]==board[row][column]) {
                return false;
            }
        }
        return true;
    }
    private static boolean isBoxValid(int[][] board, int row, int column) { //for example
        int boxRowStart = (row / 3) * 3; // row 7, boxRowStart=2*3=6
        int boxRowEnd = boxRowStart + 3; // row 7, boxRowEnd=6+3=9

        int boxColumnStart = (column / 3) * 3;
        int boxColumnEnd = boxColumnStart + 3;

        for (int r = boxRowStart; r < boxRowEnd; r++) {
            for (int c = boxColumnStart; c < boxColumnEnd; c++) {
                if (r!=row && c!=column && board[r][c]==board[row][column]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void printBoard(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    }
}


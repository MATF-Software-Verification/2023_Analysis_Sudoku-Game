package test.MyImplementation;

public class MyBacktrackingAlgorithm {
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


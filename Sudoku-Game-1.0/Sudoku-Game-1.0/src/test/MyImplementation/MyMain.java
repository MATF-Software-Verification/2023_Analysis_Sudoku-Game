package test.MyImplementation;

import com.company.Sudoku;

import static test.MyImplementation.MyBacktrackingAlgorithm.printBoard;
import static test.MyImplementation.MyBacktrackingAlgorithm.solveBacktracking;
public class MyMain {
    private static Sudoku easy = new Sudoku("165 794 038 407 002 050 930 006 004 810 405 002 576 239 400 200 601 075 301 507 849 690 000 527 050 028 103");
    private static Sudoku medium = new Sudoku("980 254 000 640 073 200 020 000 900 030 000 006 060 000 090 700 642 803 400 026 010 390 008 402 172 000 000");
    private static Sudoku hard = new Sudoku("600 500 073 500 002 004 001 003 580 903 080 705 850 037 020 076 050 000 087 300 250 010 470 006 360 821 000");
    private static Sudoku expert = new Sudoku("000 970 800 300 005 640 000 060 031 035 040 000 209 007 310 070 030 490 420 006 000 051 304 009 003 000 500");
    private static Sudoku randomSudoku=new Sudoku("000100200003000040500600700008050009000402000600070100002007008090000500004003000");
    private static Sudoku emptySudoku=new Sudoku("000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000");

    public static void main(String[] args) {
        if(solveBacktracking(easy.getBoard())){
            printBoard(easy.getBoard());
        }else{
            System.out.println("'Easy' sudoku can't be solved.");
        }
        System.out.println("______________________________");
        if(solveBacktracking(randomSudoku.getBoard())){ //this sudoku could not be solved with solve method from Sudoku class
            printBoard(randomSudoku.getBoard());
        }else{
            System.out.println("'Random' sudoku can't be solved.");
        }
        System.out.println("______________________________");
        if(solveBacktracking(emptySudoku.getBoard())){ //this sudoku could not be solved with solve method from Sudoku class
            printBoard(emptySudoku.getBoard());
        }else{
            System.out.println("'Empty' sudoku can't be solved.");
        }
        System.out.println("______________________________");





    }
}

package test;

import com.company.Sudoku;
import com.company.SudokuDisplay;
import com.company.SudokuWrapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuDisplayTest {
    private static Sudoku easy = new Sudoku("165 794 038 407 002 050 930 006 004 810 405 002 576 239 400 200 601 075 301 507 849 690 000 527 050 028 103");
    private static Sudoku medium = new Sudoku("980 254 000 640 073 200 020 000 900 030 000 006 060 000 090 700 642 803 400 026 010 390 008 402 172 000 000");
    private static Sudoku hard = new Sudoku("600 500 073 500 002 004 001 003 580 903 080 705 850 037 020 076 050 000 087 300 250 010 470 006 360 821 000");
    private static Sudoku expert = new Sudoku("000 970 800 300 005 640 000 060 031 035 040 000 209 007 310 070 030 490 420 006 000 051 304 009 003 000 500");
    private static Sudoku mySudoku=new Sudoku("100 489 200 080 020 900 000 000 057 030 000 021 290 540 000 000 000 104 001 000 000 407 086 010 900 000 083");
    private static Sudoku invalidSudoku=new Sudoku("111 111 200 080 020 900 000 000 057 030 000 021 290 540 000 000 000 104 001 000 000 407 086 010 900 000 083");
    //it's not important that sudoku is invalid, all methods from SudokuDisplay will work regularly

    private SudokuWrapper easySudokuWrapper;
    private SudokuWrapper mediumSudokuWrapper;
    private SudokuWrapper hardSudokuWrapper;
    private SudokuWrapper expertSudokuWrapper;

    private SudokuDisplay display;

    ////////////tests for toString
    @Test
    public void testingToStringEasySudoku(){
        String easyBoard="    A B C   D E F   G H I\n" +
                "  -------------------------\n" +
                "1 | 1 6 5 | 7 9 4 | - 3 8 |\n" +
                "2 | 4 - 7 | - - 2 | - 5 - |\n" +
                "3 | 9 3 - | - - 6 | - - 4 |\n" +
                "  -------------------------\n" +
                "4 | 8 1 - | 4 - 5 | - - 2 |\n" +
                "5 | 5 7 6 | 2 3 9 | 4 - - |\n" +
                "6 | 2 - - | 6 - 1 | - 7 5 |\n" +
                "  -------------------------\n" +
                "7 | 3 - 1 | 5 - 7 | 8 4 9 |\n" +
                "8 | 6 9 - | - - - | 5 2 7 |\n" +
                "9 | - 5 - | - 2 8 | 1 - 3 |\n" +
                "  -------------------------";
        display=new SudokuDisplay(easy);
        String stringBoard=display.toString();
        assertEquals(easyBoard,stringBoard);
    }
    @Test
    public void testingToStringMediumSudoku(){
        String mediumBoard="    A B C   D E F   G H I\n" +
                "  -------------------------\n" +
                "1 | 9 8 - | 2 5 4 | - - - |\n" +
                "2 | 6 4 - | - 7 3 | 2 - - |\n" +
                "3 | - 2 - | - - - | 9 - - |\n" +
                "  -------------------------\n" +
                "4 | - 3 - | - - - | - - 6 |\n" +
                "5 | - 6 - | - - - | - 9 - |\n" +
                "6 | 7 - - | 6 4 2 | 8 - 3 |\n" +
                "  -------------------------\n" +
                "7 | 4 - - | - 2 6 | - 1 - |\n" +
                "8 | 3 9 - | - - 8 | 4 - 2 |\n" +
                "9 | 1 7 2 | - - - | - - - |\n" +
                "  -------------------------";
        display=new SudokuDisplay(medium);
        String stringBoard=display.toString();
        assertEquals(mediumBoard,stringBoard);
    }
    @Test
    public void testingToStringHardSudoku(){
        String hardBoard="    A B C   D E F   G H I\n" +
                "  -------------------------\n" +
                "1 | 6 - - | 5 - - | - 7 3 |\n" +
                "2 | 5 - - | - - 2 | - - 4 |\n" +
                "3 | - - 1 | - - 3 | 5 8 - |\n" +
                "  -------------------------\n" +
                "4 | 9 - 3 | - 8 - | 7 - 5 |\n" +
                "5 | 8 5 - | - 3 7 | - 2 - |\n" +
                "6 | - 7 6 | - 5 - | - - - |\n" +
                "  -------------------------\n" +
                "7 | - 8 7 | 3 - - | 2 5 - |\n" +
                "8 | - 1 - | 4 7 - | - - 6 |\n" +
                "9 | 3 6 - | 8 2 1 | - - - |\n" +
                "  -------------------------";
        display=new SudokuDisplay(hard);
        String stringBoard=display.toString();
        assertEquals(hardBoard,stringBoard);
    }
    @Test
    public void testingToStringExpertSudoku(){
        String expertBoard="    A B C   D E F   G H I\n" +
                "  -------------------------\n" +
                "1 | - - - | 9 7 - | 8 - - |\n" +
                "2 | 3 - - | - - 5 | 6 4 - |\n" +
                "3 | - - - | - 6 - | - 3 1 |\n" +
                "  -------------------------\n" +
                "4 | - 3 5 | - 4 - | - - - |\n" +
                "5 | 2 - 9 | - - 7 | 3 1 - |\n" +
                "6 | - 7 - | - 3 - | 4 9 - |\n" +
                "  -------------------------\n" +
                "7 | 4 2 - | - - 6 | - - - |\n" +
                "8 | - 5 1 | 3 - 4 | - - 9 |\n" +
                "9 | - - 3 | - - - | 5 - - |\n" +
                "  -------------------------";
        display=new SudokuDisplay(expert);
        String stringBoard=display.toString();
        assertEquals(expertBoard,stringBoard);
    }
    @Test
    public void testingToStringMySudoku(){
        String myBoard="    A B C   D E F   G H I\n" +
                "  -------------------------\n" +
                "1 | 1 - - | 4 8 9 | 2 - - |\n" +
                "2 | - 8 - | - 2 - | 9 - - |\n" +
                "3 | - - - | - - - | - 5 7 |\n" +
                "  -------------------------\n" +
                "4 | - 3 - | - - - | - 2 1 |\n" +
                "5 | 2 9 - | 5 4 - | - - - |\n" +
                "6 | - - - | - - - | 1 - 4 |\n" +
                "  -------------------------\n" +
                "7 | - - 1 | - - - | - - - |\n" +
                "8 | 4 - 7 | - 8 6 | - 1 - |\n" +
                "9 | 9 - - | - - - | - 8 3 |\n" +
                "  -------------------------";
        display=new SudokuDisplay(mySudoku);
        String stringBoard=display.toString();
        assertEquals(myBoard,stringBoard);
    }
    @Test
    public void invalidSudokuToString(){
        String invalidBoard="    A B C   D E F   G H I\n" +
                "  -------------------------\n" +
                "1 | 1 1 1 | 1 1 1 | 2 - - |\n" +
                "2 | - 8 - | - 2 - | 9 - - |\n" +
                "3 | - - - | - - - | - 5 7 |\n" +
                "  -------------------------\n" +
                "4 | - 3 - | - - - | - 2 1 |\n" +
                "5 | 2 9 - | 5 4 - | - - - |\n" +
                "6 | - - - | - - - | 1 - 4 |\n" +
                "  -------------------------\n" +
                "7 | - - 1 | - - - | - - - |\n" +
                "8 | 4 - 7 | - 8 6 | - 1 - |\n" +
                "9 | 9 - - | - - - | - 8 3 |\n" +
                "  -------------------------";
        display=new SudokuDisplay(invalidSudoku);
        String stringBoard=display.toString();
        assertEquals(invalidBoard,stringBoard);
    }
    ///////////////tests for output
    @Test
    public void easySudokuOutput(){
        String easyBoard="    A B C   D E F   G H I\n" +
                "  -------------------------\n" +
                "1 | 1 6 5 | 7 9 4 | - 3 8 |\n" +
                "2 | 4 - 7 | - - 2 | - 5 - |\n" +
                "3 | 9 3 - | - - 6 | - - 4 |\n" +
                "  -------------------------\n" +
                "4 | 8 1 - | 4 - 5 | - - 2 |\n" +
                "5 | 5 7 6 | 2 3 9 | 4 - - |\n" +
                "6 | 2 - - | 6 - 1 | - 7 5 |\n" +
                "  -------------------------\n" +
                "7 | 3 - 1 | 5 - 7 | 8 4 9 |\n" +
                "8 | 6 9 - | - - - | 5 2 7 |\n" +
                "9 | - 5 - | - 2 8 | 1 - 3 |\n" +
                "  -------------------------";
        display=new SudokuDisplay(easy);
        String stringBoard=display.output();
        assertEquals(easyBoard,stringBoard);
    }
    @Test
    public void mySudokuOutputChangedFieldsB1andG7(){
        String myBoard="    A B C   D E F   G H I\n" +
                "  -------------------------\n" +
                "1 | 1 5 - | 4 8 9 | 2 - - |\n" +
                "2 | - 8 - | - 2 - | 9 - - |\n" +
                "3 | - - - | - - - | - 5 7 |\n" +
                "  -------------------------\n" +
                "4 | - 3 - | - - - | - 2 1 |\n" +
                "5 | 2 9 - | 5 4 - | - - - |\n" +
                "6 | - - - | - - - | 1 - 4 |\n" +
                "  -------------------------\n" +
                "7 | - - 1 | - - - | 6 - - |\n" +
                "8 | 4 - 7 | - 8 6 | - 1 - |\n" +
                "9 | 9 - - | - - - | - 8 3 |\n" +
                "  -------------------------";
        assertTrue(mySudoku.add(1,0,5));
        assertTrue(mySudoku.add(6,6,6));
        display=new SudokuDisplay(mySudoku);
        String stringBoard=display.output();
        assertEquals(myBoard,stringBoard);
    }
    @Test
    public void easySudokuOutputChangedFieldH4(){
        String easyBoard="    A B C   D E F   G H I\n" +
                "  -------------------------\n" +
                "1 | 1 6 5 | 7 9 4 | - 3 8 |\n" +
                "2 | 4 - 7 | - - 2 | - 5 - |\n" +
                "3 | 9 3 - | - - 6 | - - 4 |\n" +
                "  -------------------------\n" +
                "4 | 8 1 - | 4 - 5 | - 6 2 |\n" +
                "5 | 5 7 6 | 2 3 9 | 4 - - |\n" +
                "6 | 2 - - | 6 - 1 | - 7 5 |\n" +
                "  -------------------------\n" +
                "7 | 3 - 1 | 5 - 7 | 8 4 9 |\n" +
                "8 | 6 9 - | - - - | 5 2 7 |\n" +
                "9 | - 5 - | - 2 8 | 1 - 3 |\n" +
                "  -------------------------";
        assertTrue(easy.add(7,3,6));
        display=new SudokuDisplay(easy);
        String stringBoard=display.output();
        assertEquals(easyBoard,stringBoard);
    }
    @Test
    public void expertSudokuOutputChangedFieldA1(){
        String expertBoard="    A B C   D E F   G H I\n" +
                "  -------------------------\n" +
                "1 | 5 - - | 9 7 - | 8 - - |\n" +
                "2 | 3 - - | - - 5 | 6 4 - |\n" +
                "3 | - - - | - 6 - | - 3 1 |\n" +
                "  -------------------------\n" +
                "4 | - 3 5 | - 4 - | - - - |\n" +
                "5 | 2 - 9 | - - 7 | 3 1 - |\n" +
                "6 | - 7 - | - 3 - | 4 9 - |\n" +
                "  -------------------------\n" +
                "7 | 4 2 - | - - 6 | - - - |\n" +
                "8 | - 5 1 | 3 - 4 | - - 9 |\n" +
                "9 | - - 3 | - - - | 5 - - |\n" +
                "  -------------------------";
        assertTrue(expert.add(0,0,5));
        display=new SudokuDisplay(expert);
        String stringBoard=display.output();
        assertEquals(expertBoard,stringBoard);
    }
    @Test
    public void mediumSudokuOutputTryingToChangeOccupiedFieldA9(){
        String mediumBoard="    A B C   D E F   G H I\n" +
                "  -------------------------\n" +
                "1 | 9 8 - | 2 5 4 | - - - |\n" +
                "2 | 6 4 - | - 7 3 | 2 - - |\n" +
                "3 | - 2 - | - - - | 9 - - |\n" +
                "  -------------------------\n" +
                "4 | - 3 - | - - - | - - 6 |\n" +
                "5 | - 6 - | - - - | - 9 - |\n" +
                "6 | 7 - - | 6 4 2 | 8 - 3 |\n" +
                "  -------------------------\n" +
                "7 | 4 - - | - 2 6 | - 1 - |\n" +
                "8 | 3 9 - | - - 8 | 4 - 2 |\n" +
                "9 | 8 7 2 | - - - | - - - |\n" +
                "  -------------------------";
        assertFalse(medium.add(0,8,8));
        display=new SudokuDisplay(medium);
        String stringBoard=display.output();
        assertNotEquals(mediumBoard,stringBoard);
    }
    @Test
    public void hardSudokuOutputAddingAndRemovingValueD9(){
        String hardBoard="    A B C   D E F   G H I\n" +
                "  -------------------------\n" +
                "1 | 6 - - | 5 - - | - 7 3 |\n" +
                "2 | 5 - - | - - 2 | - - 4 |\n" +
                "3 | - - 1 | - - 3 | 5 8 - |\n" +
                "  -------------------------\n" +
                "4 | 9 - 3 | - 8 - | 7 - 5 |\n" +
                "5 | 8 5 - | - 3 7 | - 2 - |\n" +
                "6 | - 7 6 | - 5 - | - - - |\n" +
                "  -------------------------\n" +
                "7 | - 8 7 | 3 - - | 2 5 - |\n" +
                "8 | - 1 - | 4 7 - | - - 6 |\n" +
                "9 | 3 6 - | 8 2 1 | - - - |\n" +
                "  -------------------------";
        assertTrue(hard.add(3,5,2));
        assertEquals(2,hard.remove(3,5));
        display=new SudokuDisplay(hard);
        String stringBoard=display.output();
        assertEquals(hardBoard,stringBoard);
    }
    @Test
    public void invalidSudokuOutputChangedFieldF2(){
        String invalidBoard="    A B C   D E F   G H I\n" +
                "  -------------------------\n" +
                "1 | 1 1 1 | 1 1 1 | 2 - - |\n" +
                "2 | - 8 - | - 2 7 | 9 - - |\n" +
                "3 | - - - | - - - | - 5 7 |\n" +
                "  -------------------------\n" +
                "4 | - 3 - | - - - | - 2 1 |\n" +
                "5 | 2 9 - | 5 4 - | - - - |\n" +
                "6 | - - - | - - - | 1 - 4 |\n" +
                "  -------------------------\n" +
                "7 | - - 1 | - - - | - - - |\n" +
                "8 | 4 - 7 | - 8 6 | - 1 - |\n" +
                "9 | 9 - - | - - - | - 8 3 |\n" +
                "  -------------------------";
        assertTrue(invalidSudoku.add(5,1,7));
        display=new SudokuDisplay(invalidSudoku);
        String stringBoard=display.output();
        assertEquals(invalidBoard,stringBoard);
    }
    //////tests for getBoardAsString
    @Test
    public void easySudokuGetBoardAsString(){
        display=new SudokuDisplay(easy);
        assertEquals(display.getBoardAsString(),"165 794 038 407 002 050 930 006 004 810 405 002 576 239 400 200 601 075 301 507 849 690 000 527 050 028 103");
    }
    @Test
    public void hardSudokuGetBoardAsString(){
        display=new SudokuDisplay(hard);
        assertEquals(display.getBoardAsString(),"600 500 073 500 002 004 001 003 580 903 080 705 850 037 020 076 050 000 087 300 250 010 470 006 360 821 000");
    }
    @Test
    public void mySudokuGetBoardAsString(){
        display=new SudokuDisplay(mySudoku);
        assertEquals(display.getBoardAsString(),"100 489 200 080 020 900 000 000 057 030 000 021 290 540 000 000 000 104 001 000 000 407 086 010 900 000 083");
    }
    @Test
    public void invalidSudokuGetBoardAsString(){
        display=new SudokuDisplay(invalidSudoku);
        assertEquals(display.getBoardAsString(),"111 111 200 080 020 900 000 000 057 030 000 021 290 540 000 000 000 104 001 000 000 407 086 010 900 000 083");
    }
}
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
import java.util.InputMismatchException;

import static com.company.UserTypeInField.parseAdd;
import static org.junit.jupiter.api.Assertions.*;
public class SudokuTest {
    private static Sudoku easy = new Sudoku("165 794 038 407 002 050 930 006 004 810 405 002 576 239 400 200 601 075 301 507 849 690 000 527 050 028 103");
    private static Sudoku medium = new Sudoku("980 254 000 640 073 200 020 000 900 030 000 006 060 000 090 700 642 803 400 026 010 390 008 402 172 000 000");
    private static Sudoku hard = new Sudoku("600 500 073 500 002 004 001 003 580 903 080 705 850 037 020 076 050 000 087 300 250 010 470 006 360 821 000");
    private static Sudoku expert = new Sudoku("000 970 800 300 005 640 000 060 031 035 040 000 209 007 310 070 030 490 420 006 000 051 304 009 003 000 500");
    private static Sudoku mySudoku=new Sudoku("100 489 200 080 020 900 000 000 057 030 000 021 290 540 000 000 000 104 001 000 000 407 086 010 900 000 083");
    private static Sudoku invalidSudoku=new Sudoku("111 111 200 080 020 900 000 000 057 030 000 021 290 540 000 000 000 104 001 000 000 407 086 010 900 000 083");
    private static Sudoku addedExtraFieldSudoku;
    private static SudokuDisplay display;

    //invalid initialization
    @Test
    public void testingConstructorMissingFieldSudoku(){
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            Sudoku missingFieldSudoku=new Sudoku("530 070 000 600 195 000 098 000 060 800 060 003 400 803 001 700 020 006 060 000 280 000 419 005 000 080 79");
        });
    }
    @Test
    public void testingConstructorAddedExtraFieldSudoku(){ //there should exist a method that checks if values (while initializing) are fixed length 81
        assertThrows(Exception.class, () -> {
            addedExtraFieldSudoku= new Sudoku("1100 489 200 080 020 900 000 000 057 030 000 021 290 540 000 000 000 104 001 000 000 407 086 010 900 000 083");
        });

        SudokuDisplay display=new SudokuDisplay(addedExtraFieldSudoku);
        System.out.println(display.toString());
    }
    @Test
    public void testingConstructorMissingRowSudoku(){
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            Sudoku missingRowSudoku= new Sudoku("407 002 050 930 006 004 810 405 002 576 239 400 200 601 075 301 507 849 690 000 527 050 028 103");
        });
    }
    @Test
    public void testingConstructorMissingColSudoku(){
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            Sudoku missingColSudoku= new Sudoku("90 24 00 60 03 20 00 00 90 00 00 06 00 00 00 70 62 83 40 06 00 30 08 42 12 00 00");
        });
    }
    @Test
    public void testingConstructorSmallerInvalidSudoku(){
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            Sudoku smallerInvalidSudoku= new Sudoku("109 200 400");
        });
    }
    //tests for method solve
    //tests for method add
    @Test
    public void addInEasyFieldC9(){
        assertTrue(easy.add(2,8,4));
    }
    @Test
    public void addInMediumOccupiedFieldA2(){
        assertFalse(medium.add(0,1,4));
    }
    @Test
    public void addInHardTwoFieldsG9F7(){
        assertTrue(hard.add(7,8,4));
        assertTrue(hard.add(5,6,9));
    }
    @Test
    public void addTwiceInTheSameFieldExpert(){
        assertTrue(expert.add(4,1,2));
        assertTrue(expert.add(4,1,8));
    }
    @Test
    public void addingWrongValueInMySudoku(){
        assertFalse(hard.add(8,7,7));
        assertFalse(hard.add(8,7,8));
        assertFalse(hard.add(8,7,3));
    }
    @Test
    public void mediumSudokuOutputTryingToChangeOccupiedFieldA9() {
        assertFalse(medium.add(0, 7, 1));
    }





    //tests for method remove
    //tests for method isSolved


}

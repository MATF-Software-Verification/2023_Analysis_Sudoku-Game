package test;

import com.company.Sudoku;
import com.company.SudokuDisplay;
import com.company.SudokuWrapper;
import com.company.UserChoosingDifficulty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static com.company.UserTypeInField.parseAdd;
import static org.junit.jupiter.api.Assertions.*;

public class UserTypeInFieldTest {
    private static Sudoku easy = new Sudoku("165 794 038 407 002 050 930 006 004 810 405 002 576 239 400 200 601 075 301 507 849 690 000 527 050 028 103");
    private static Sudoku medium = new Sudoku("980 254 000 640 073 200 020 000 900 030 000 006 060 000 090 700 642 803 400 026 010 390 008 402 172 000 000");
    private static Sudoku hard = new Sudoku("600 500 073 500 002 004 001 003 580 903 080 705 850 037 020 076 050 000 087 300 250 010 470 006 360 821 000");
    private static Sudoku expert = new Sudoku("000 970 800 300 005 640 000 060 031 035 040 000 209 007 310 070 030 490 420 006 000 051 304 009 003 000 500");

    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;
    private SudokuWrapper easySudokuWrapper;
    private SudokuWrapper mediumSudokuWrapper;
    private SudokuWrapper hardSudokuWrapper;
    private SudokuWrapper expertSudokuWrapper;
    private SudokuDisplay display;

    @BeforeEach
    public void setUp() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        easySudokuWrapper=new SudokuWrapper(easy);
        mediumSudokuWrapper=new SudokuWrapper(medium);
        hardSudokuWrapper=new SudokuWrapper(hard);
        expertSudokuWrapper=new SudokuWrapper(expert);
    }
    @AfterEach
    public void restoreSystem() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }
    public void setUpInput(String input) {
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
    }
    public int letterToNumber(char c){
        switch (c) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            case 'E':
                return 4;
            case 'F':
                return 5;
            case 'G':
                return 6;
            case 'H':
                return 7;
            case 'I':
                return 8;
        }
        return -1;
    }
    @Test
    public void fieldFromFirstBoxInMediumSudoku(){
        String str="C1";
        int col=letterToNumber(str.charAt(0));
        char rowChar=str.charAt(str.length() - 1);
        int row=Character.getNumericValue(rowChar)-1;
        setUpInput("1\n");
        assertEquals(mediumSudokuWrapper.sudoku.add(col,row,1),parseAdd(mediumSudokuWrapper,str));
    //    display=new SudokuDisplay(mediumSudokuWrapper.sudoku);
    //    assertTrue(testOut.toString().contains(display.toString()));
    }
    @Test
    public void fieldFromThirdBoxInExpert(){
        String str="I3";
        int col=letterToNumber(str.charAt(0));
        char rowChar=str.charAt(str.length() - 1);
        int row=Character.getNumericValue(rowChar)-1;
        setUpInput("5\n");
        assertEquals(expertSudokuWrapper.sudoku.add(col,row,5),parseAdd(expertSudokuWrapper,str));
    }
    @Test
    public void fieldFromNinthBoxInHard(){
        String str="G8";
        int col=letterToNumber(str.charAt(0));
        char rowChar=str.charAt(str.length() - 1);
        int row=Character.getNumericValue(rowChar)-1;
        setUpInput("8\n");
        assertEquals(hardSudokuWrapper.sudoku.add(col,row,8),parseAdd(hardSudokuWrapper,str));
    }

}
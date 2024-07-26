package test;

import com.company.Sudoku;
import com.company.SudokuDisplay;
import com.company.SudokuWrapper;
import com.company.UserChoosingDifficulty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static com.company.UserChoosingDifficulty.difficulty;
import static org.junit.jupiter.api.Assertions.*;

class UserChoosingDifficultyTest {
    private static Sudoku easy = new Sudoku("165 794 038 407 002 050 930 006 004 810 405 002 576 239 400 200 601 075 301 507 849 690 000 527 050 028 103");
    private static Sudoku medium = new Sudoku("980 254 000 640 073 200 020 000 900 030 000 006 060 000 090 700 642 803 400 026 010 390 008 402 172 000 000");
    private static Sudoku hard = new Sudoku("600 500 073 500 002 004 001 003 580 903 080 705 850 037 020 076 050 000 087 300 250 010 470 006 360 821 000");
    private static Sudoku expert = new Sudoku("000 970 800 300 005 640 000 060 031 035 040 000 209 007 310 070 030 490 420 006 000 051 304 009 003 000 500");
    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;


    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
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
    @Test
    public void testDifficultyEasy() {
        setUpInput("1\n");
        SudokuWrapper usrSudokuWrapper = new SudokuWrapper(easy);
        SudokuDisplay displayEasy=new SudokuDisplay(easy);
        int result = difficulty(usrSudokuWrapper);
        assertEquals(1, result);
        assertTrue(testOut.toString().contains(displayEasy.toString()));
    }
    @Test
    public void testDifficultyMedium() {
        setUpInput("2\n");
        SudokuWrapper usrSudokuWrapper = new SudokuWrapper(medium);
        SudokuDisplay displayEasy=new SudokuDisplay(medium);
        int result = difficulty(usrSudokuWrapper);
        assertEquals(1, result);
        assertTrue(testOut.toString().contains(displayEasy.toString()));
    }
    @Test
    public void testDifficultyHard() {
        setUpInput("3\n");
        SudokuWrapper usrSudokuWrapper = new SudokuWrapper(hard);
        SudokuDisplay displayEasy=new SudokuDisplay(hard);
        int result = difficulty(usrSudokuWrapper);
        assertEquals(1, result);
        assertTrue(testOut.toString().contains(displayEasy.toString()));
    }

    @Test
    public void testDifficultyExpert() {
        setUpInput("4\n");
        SudokuWrapper usrSudokuWrapper = new SudokuWrapper(expert);
        SudokuDisplay displayEasy=new SudokuDisplay(expert);
        int result = difficulty(usrSudokuWrapper);
        assertEquals(1, result);
        assertTrue(testOut.toString().contains(displayEasy.toString()));
    }
    @Test
    public void inputForExit(){
        setUpInput("5\n");
        SudokuWrapper usrSudokuWrapper = new SudokuWrapper(expert);
        int result = difficulty(usrSudokuWrapper);
        assertEquals(0, result);
    }
    //for invalid inputs, type of sudoku doesn't matter
    @Test
    public void invalidInputNumberOnUpperBound(){
        setUpInput("6\n");
        SudokuWrapper usrSudokuWrapper = new SudokuWrapper(expert);
        int result = difficulty(usrSudokuWrapper);
        assertEquals(-1, result);
    }
    @Test
    public void invalidInputNumberOnLowerBound(){
        setUpInput("0\n");
        SudokuWrapper usrSudokuWrapper = new SudokuWrapper(expert);
        int result = difficulty(usrSudokuWrapper);
        assertEquals(-1, result);
    }
    @Test
    public void invalidInputNegativeNumber(){
        setUpInput("-1\n");
        SudokuWrapper usrSudokuWrapper = new SudokuWrapper(expert);
        int result = difficulty(usrSudokuWrapper);
        assertEquals(-1, result);
    }
    @Test
    public void invalidInputBiggerNumber(){
        setUpInput("100\n");
        SudokuWrapper usrSudokuWrapper = new SudokuWrapper(expert);
        int result = difficulty(usrSudokuWrapper);
        assertEquals(-1, result);
    }
    @Test
    public void invalidInputString(){
        setUpInput("a\n");
        SudokuWrapper usrSudokuWrapper = new SudokuWrapper(expert);
        int result = difficulty(usrSudokuWrapper);
        assertEquals(-1, result);
    }

}
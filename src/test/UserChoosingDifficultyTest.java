package test;

import com.company.Sudoku;
import com.company.SudokuDisplay;
import com.company.SudokuWrapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static com.company.UserChoosingDifficulty.difficulty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class UserChoosingDifficultyTest {
    private static Sudoku easy = new Sudoku("165 794 038 407 002 050 930 006 004 810 405 002 576 239 400 200 601 075 301 507 849 690 000 527 050 028 103");
    private static Sudoku medium = new Sudoku("980 254 000 640 073 200 020 000 900 030 000 006 060 000 090 700 642 803 400 026 010 390 008 402 172 000 000");
    private static Sudoku hard = new Sudoku("600 500 073 500 002 004 001 003 580 903 080 705 850 037 020 076 050 000 087 300 250 010 470 006 360 821 000");
    private static Sudoku expert = new Sudoku("000 970 800 300 005 640 000 060 031 035 040 000 209 007 310 070 030 490 420 006 000 051 304 009 003 000 500");
    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;
    private SudokuWrapper usrSudokuWrapper;
    private SudokuDisplay display;


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
        Scanner scanner = mock(Scanner.class);
        when(scanner.next()).thenReturn("1");

        usrSudokuWrapper = new SudokuWrapper(easy);
        display = new SudokuDisplay(easy);

        int result = difficulty(usrSudokuWrapper, scanner);

        assertEquals(1, result);
        assertTrue(testOut.toString().contains(display.toString()));

        verify(scanner).next();
    }
    @Test
    public void testDifficultyMedium() {
        Scanner scanner = mock(Scanner.class);
        when(scanner.next()).thenReturn("2");

        usrSudokuWrapper = new SudokuWrapper(medium);
        display = new SudokuDisplay(medium);

        int result = difficulty(usrSudokuWrapper, scanner);

        assertEquals(1, result);
        assertTrue(testOut.toString().contains(display.toString()));

        verify(scanner).next();
    }
    @Test
    public void testDifficultyHard() {
        Scanner scanner = mock(Scanner.class);
        when(scanner.next()).thenReturn("3");

        usrSudokuWrapper = new SudokuWrapper(hard);
        display = new SudokuDisplay(hard);

        int result = difficulty(usrSudokuWrapper, scanner);

        assertEquals(1, result);
        assertTrue(testOut.toString().contains(display.toString()));

        verify(scanner).next();
    }

    @Test
    public void testDifficultyExpert() {
        Scanner scanner = mock(Scanner.class);
        when(scanner.next()).thenReturn("4");

        usrSudokuWrapper = new SudokuWrapper(expert);
        display = new SudokuDisplay(expert);

        int result = difficulty(usrSudokuWrapper, scanner);

        assertEquals(1, result);
        assertTrue(testOut.toString().contains(display.toString()));

        verify(scanner).next();
    }
    @Test
    public void inputForExit(){
        Scanner scanner = mock(Scanner.class);
        when(scanner.next()).thenReturn("5");

        usrSudokuWrapper = new SudokuWrapper(expert);

        int result = difficulty(usrSudokuWrapper,scanner);

        assertEquals(0, result);

        verify(scanner).next();
    }
    //for invalid inputs, type of sudoku doesn't matter
    @Test
    public void invalidInputNumberOnUpperBound(){
        Scanner scanner = mock(Scanner.class);
        when(scanner.next()).thenReturn("6");

        usrSudokuWrapper = new SudokuWrapper(expert);

        int result = difficulty(usrSudokuWrapper,scanner);

        assertEquals(-1, result);
        verify(scanner).next();
    }
    @Test
    public void invalidInputNumberOnLowerBound(){
        Scanner scanner = mock(Scanner.class);
        when(scanner.next()).thenReturn("0");

        usrSudokuWrapper = new SudokuWrapper(expert);

        int result = difficulty(usrSudokuWrapper,scanner);
        assertEquals(-1, result);

        verify(scanner).next();

    }
    @Test
    public void invalidInputNegativeNumber(){
        Scanner scanner = mock(Scanner.class);
        when(scanner.next()).thenReturn("-1");

        usrSudokuWrapper = new SudokuWrapper(expert);

        int result = difficulty(usrSudokuWrapper,scanner);
        assertEquals(-1, result);

        verify(scanner).next();
    }
    @Test
    public void invalidInputBiggerNumber(){
        Scanner scanner = mock(Scanner.class);
        when(scanner.next()).thenReturn("100");

        usrSudokuWrapper = new SudokuWrapper(expert);

        int result = difficulty(usrSudokuWrapper,scanner);
        assertEquals(-1, result);

        verify(scanner).next();
    }
    @Test
    public void invalidInputString(){
        Scanner scanner = mock(Scanner.class);
        when(scanner.next()).thenReturn("a");

        usrSudokuWrapper = new SudokuWrapper(expert);

        int result = difficulty(usrSudokuWrapper,scanner);
        assertEquals(-1, result);

        verify(scanner).next();
    }


}
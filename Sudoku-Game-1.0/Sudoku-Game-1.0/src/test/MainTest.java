package test;

import com.company.Main;
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

import static org.junit.jupiter.api.Assertions.assertTrue;
class MainTest {
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
    @Test
    public void testPlayEasy(){
        String simulatedInput="1\n1\nA9\n7\n4\n5";
        setUpInput(simulatedInput);

        Main.main(null);
        assertTrue(testOut.toString().contains("Successfully added 7 to A9"));
    }
    @Test
    public void testPlayMedium(){
        String simulatedInput="2\n1\nG1\n1\n4\n5";
        setUpInput(simulatedInput);

        Main.main(null);
        assertTrue(testOut.toString().contains("Successfully added 1 to G1"));
    }
    @Test
    public void testPlayExpertShowSolution(){
        String simulatedInput="4\n3\n5";
        setUpInput(simulatedInput);

        Main.main(null);

        assertTrue(testOut.toString().contains("    A B C   D E F   G H I\n" +
                "  -------------------------\n" +
                "1 | 6 1 4 | 9 7 3 | 8 5 2 |\n" +
                "2 | 3 9 2 | 8 1 5 | 6 4 7 |\n" +
                "3 | 5 8 7 | 4 6 2 | 9 3 1 |\n" +
                "  -------------------------\n" +
                "4 | 8 3 5 | 1 4 9 | 7 2 6 |\n" +
                "5 | 2 4 9 | 6 5 7 | 3 1 8 |\n" +
                "6 | 1 7 6 | 2 3 8 | 4 9 5 |\n" +
                "  -------------------------\n" +
                "7 | 4 2 8 | 5 9 6 | 1 7 3 |\n" +
                "8 | 7 5 1 | 3 8 4 | 2 6 9 |\n" +
                "9 | 9 6 3 | 7 2 1 | 5 8 4 |\n" +
                "  -------------------------"));
    }
    @Test
    public void testPlayHardCantFillValue(){
        String simulatedInput="3\n1\nB2\n4\n4\n5";
        setUpInput(simulatedInput);

        Main.main(null);
        assertTrue(testOut.toString().contains("Can't fill this value in this place, try again..."));
    }
    @Test
    public void testPlayWrongInput1to5(){
        String simulatedInput="1\n6\n4\n5";
        setUpInput(simulatedInput);

        Main.main(null);
        assertTrue(testOut.toString().contains("Invalid input, try again..."));
    }
    @Test
    public void testPlayWrongInputForDifficulty(){
        String simulatedInput="6\n5\n";
        setUpInput(simulatedInput);

        Main.main(null);
        assertTrue(testOut.toString().contains("Invalid difficulty selection, try again..."));
    }
    @Test
    public void testPlayMediumUndo(){
        String simulatedInput="2\n1\nc2\n1\n2\n4\n5\n";
        setUpInput(simulatedInput);

        Main.main(null);
        assertTrue(testOut.toString().contains("Successfully added 1 to C2"));
    }
    @Test
    public void testPlayMediumInvalidUndoing(){
        String simulatedInput="2\n2\n4\n5";
        setUpInput(simulatedInput);

        Main.main(null);
        assertTrue(testOut.toString().contains("Can't undo"));
    }
}
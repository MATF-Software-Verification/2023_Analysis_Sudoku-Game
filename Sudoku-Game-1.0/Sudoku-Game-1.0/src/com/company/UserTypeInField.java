package com.company;

import java.util.Scanner;

public class UserTypeInField { //class extracted from primary Main class
    private static Sudoku usrSudoku;

    public static boolean parseAdd(String str) {
        SudokuDisplay display=new SudokuDisplay(usrSudoku);
        Scanner scanner = new Scanner(System.in);
        if (str.matches("[A-I][1-9]")) {
            int colASCII = (int)str.charAt(0);
            int rowASCII = (int)str.charAt(1);
            System.out.println("\nNow type in the value...");
            int usrValue = scanner.nextInt();
            if (usrValue <= 9 && usrValue >= 1) {
                if (usrSudoku.add(colASCII - 65, rowASCII - 49, usrValue)) {
                    System.out.println("Successfully added " + usrValue + " to " + str + "\n");
                    System.out.println(display.output());
                    return true;
                }
            }
        }
        else {
            return false;
        }
        return false;
    }
}

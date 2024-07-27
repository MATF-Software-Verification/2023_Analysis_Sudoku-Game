package com.company;

public class proba {
    public static int letterToNumber(char c){
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
    public static void main(String[] args) {
        String str="C5";
        int col=letterToNumber(str.charAt(0));
        char rowChar=str.charAt(str.length() - 1);
        int row=Character.getNumericValue(rowChar);
        System.out.println(col+" "+row);
    }
}

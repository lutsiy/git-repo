/**
 * Java 1. Home Work 2
 * @autor Ilya Lutsevich
 * @version dated Nov 25 2017
 */

import  java.util.Arrays;

public class Lesson_02 {
    public static void main(String[] args) {
        System.out.println("Task 1");
        change();

        System.out.println("Task 2");
        fill();

        System.out.println("Task 3");
        multiplication();

        System.out.println("Task 4");
        twoDimensionalArray();

        System.out.println("Task 5");
        MinMax();

        System.out.println("Task 6");
        int[] arrayForBalance = {1, 1, 1, 2, 1};
        //int[] arrayForBalance = {2, 1, 1, 2, 1};
        //int[] arrayForBalance = {10,10};
        checkBalance(arrayForBalance);

        System.out.println("Task 7");
        int[] arrayForDepose = {1, 2, 3, 4, 5};
        int n = -2;
        //int n = 2;
        depose(arrayForDepose, n);
    }

    public static void change() {
        int[] a = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        System.out.println("Before");
        System.out.println(Arrays.toString(a));

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                a[i] = 0;
            } else if (a[i] == 0) {
                a[i] = 1;
            }
        }
        System.out.println("After");
        System.out.println(Arrays.toString(a));
        System.out.println("////////");
        System.out.println("");
        //


    }

    public static void fill() {

        int[] a = new int[8];

        for (int i = 0, b = 0; i < 8; i++) {

            a[i] = b;
            b = b + 3;
        }
        System.out.println(Arrays.toString(a));
        System.out.println("////////");
        System.out.println("");
    }

    public static void multiplication() {

        int[] a = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("Before");
        System.out.println(Arrays.toString(a));

        for (int i = 0; i < a.length; i++) {
            if (a[i] < 6) a[i] = a[i] * 2;
        }

        System.out.println("After");
        System.out.println(Arrays.toString(a));
        System.out.println("////////");
        System.out.println("");
    }

    public static void twoDimensionalArray() {
        int[][] a = new int[6][6];

        for (int i = 0; i < 6; i++) {

            for (int j = 0; j < 6; j++) {

                if (i == j) {
                    a[i][j] = 1;
                } else a[i][j] = 0;

            }

        }

        for (int i = 5, j = 0; i >= 0; i--, j++) {

            a[i][j] = 1;
        }


        for (int b = 0; b < 6; b++) {
            System.out.println(Arrays.toString(a[b]));
        }
        System.out.println("////////");
        System.out.println("");
    }

    public static void MinMax() {


        int[] a = {7, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 122};
        int Min = a[0];
        int Max = a[0];

        System.out.println("Array:");
        System.out.println(Arrays.toString(a));

        for (int i = 0; i < a.length; i++) {
            if (a[i] > Max) Max = a[i];
            if (a[i] < Min) Min = a[i];
        }

        System.out.println("Max: " + Max);
        System.out.println("Min: " + Min);
        System.out.println("////////");
        System.out.println("");

    }

    public static void checkBalance(int[] arrayForBalance) {

        System.out.println("Array:");
        System.out.println(Arrays.toString(arrayForBalance));

        boolean res = false;
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < arrayForBalance.length; i++) {
            sumLeft = sumLeft + arrayForBalance[i];
            sumRight = 0;
            for (int j = i + 1; j < arrayForBalance.length; j++) {
                sumRight = sumRight + arrayForBalance[j];
            }
            if (sumLeft == sumRight) {
//                System.out.println("sumLeft = " + sumLeft);
//                System.out.println("sumRight = " + sumRight);
                res = true;
            }
        }
        System.out.println(res);
        System.out.println("////////");
        System.out.println("");

    }

    public static void depose(int[] arrayForBalance, int n) {

        System.out.println("Before:");
        System.out.println(Arrays.toString(arrayForBalance));

        if (n < 0) {
            for (int j = 0; j < n*-1; j++) {
                int firstElement = arrayForBalance[0];
                for (int i = 0; i < arrayForBalance.length - 1; i++) {
                    arrayForBalance[i] = arrayForBalance[i + 1];
                }
                arrayForBalance[arrayForBalance.length - 1] = firstElement;
            }
        } else if (n > 0) {
            for (int j = 0; j < n; j++) {
                int lenght = arrayForBalance.length-1;
                int LastElement = arrayForBalance[arrayForBalance.length-1];
                for (int i = lenght; i >= 1; i--) {
                    arrayForBalance[i] = arrayForBalance[i-1];
                }
                arrayForBalance[0] = LastElement;
            }
        }
        if (n > 0) {
            System.out.println("After despose to " + n + " (→)");
        } else {

            System.out.println("After despose to " + n + " (←)");
        }
        System.out.println(Arrays.toString(arrayForBalance));
        System.out.println("////////");
        System.out.println("");
    }


}



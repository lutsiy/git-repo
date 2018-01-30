package ru.geekbrains.java2.lesson2;

public class Main {

    public static void main(String[] args) {

        int ARRAY_LENGTH = 4;

        int[][] arr = new int[ARRAY_LENGTH][ARRAY_LENGTH];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = i + j;
            }
        }

        arr[1][1] = 's';

        int sum = 0;

        try {
            sum = checkSize(arr);
        } catch (MyArraySizeException e) {
            System.out.println("Неверный размер массива!");
        } catch (MyArrayDataException e) {
            System.out.println("Неверные данные в ячейке [" + e.getX() + "] [" + e.getY() + "] ");
        }


        System.out.printf("Сумма: " + sum);
    }


        public static int checkSize(int[][] arr) throws MyArraySizeException{


            if (arr.length > 4) {
                throw new MyArraySizeException();
            }
            if (arr[0].length > 4) {
                throw new MyArraySizeException();
            }


    char s;
    int sum = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
              s = (char)arr[i][j];
                if (Character.isDigit(s)){
                 sum = sum + arr[i][j];
            } else {
              throw new MyArrayDataException(i,j);
            }
    }

    }

            return sum;
        }
}

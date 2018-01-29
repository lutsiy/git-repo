package ru.geekbrains.java2.lesson2;

public class Main {

    public static void main(String[] args) {

        int ARRAY_LENGTH = 5;

       int[][] arr = new int[ARRAY_LENGTH][ARRAY_LENGTH];

       for (int i = 0; i < arr.length; i++ ){
           for (int j = 0; j < arr.length; j++){
               arr[i][j] = i+j;
           }
       }
        try{checkSize(arr);}
        catch (MyArraySizeException e){e.printStackTrace();}
    }
    public static void checkSize(int[][] arr) throws MyArraySizeException{

        try {
            if (arr.length > 4) {
                throw new MyArraySizeException("Неверный размер массива!");
            }
            if (arr[0].length > 4) {
                throw new MyArraySizeException("Неверный размер массива!");
            }
        }catch (MyArraySizeException e){throw new MyArraySizeException("Неверный размер массива!"); }


    int sum = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
              sum = sum + arr[i][j];
            }
    }

        System.out.printf("Cумма: "+ sum);



    }

}

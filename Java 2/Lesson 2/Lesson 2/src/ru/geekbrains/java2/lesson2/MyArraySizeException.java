package ru.geekbrains.java2.lesson2;

public class MyArraySizeException extends  RuntimeException{

    public MyArraySizeException(String message) {
        super("Неверный размер массива!");
    }

    public MyArraySizeException(String message, Throwable cause) {
        super(message, cause);
    }
}

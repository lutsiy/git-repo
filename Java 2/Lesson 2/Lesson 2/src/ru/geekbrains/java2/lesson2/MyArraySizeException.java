package ru.geekbrains.java2.lesson2;

public class MyArraySizeException extends  RuntimeException{

    public MyArraySizeException() {

    }

    public MyArraySizeException(String message, Throwable cause) {
        super(message, cause);
    }
}

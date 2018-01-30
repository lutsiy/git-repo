package ru.geekbrains.java2.lesson2;

public class MyArrayDataException extends RuntimeException {
    int x;
    int y;

    public MyArrayDataException(int _x, int _y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

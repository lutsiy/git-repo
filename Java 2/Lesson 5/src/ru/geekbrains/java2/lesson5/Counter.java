package ru.geekbrains.java2.lesson5;

public class Counter {
    private int c;

    public int value() {
        return c;
    }

    public Counter() {
        this.c = 0;
    }

    public synchronized void inc(){
        c++;
    }
    public synchronized void dec(){
        c--;
    }
}

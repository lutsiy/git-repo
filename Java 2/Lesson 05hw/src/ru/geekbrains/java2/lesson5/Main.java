package ru.geekbrains.java2.lesson5;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;

public class Main {
    final  static int SIZE = 10_000_000;
    final static int THREADS_COUNT = 5;
    final static int PART_SIZE = SIZE/THREADS_COUNT;

    public static void main(String[] args) {
        singleThread();
        multiThreading();
        multiThreadingUp();
    }

    public static void singleThread(){
        float[] array = new float[SIZE];
        Arrays.fill(array, 1f);
        long time1 = System.currentTimeMillis();
        calculate(array, 0);
        long time2 = System.currentTimeMillis();
        System.out.println("Один поток: " + (time2 - time1));
    }

    public static void multiThreading(){
        float[] array = new float[SIZE];
        Arrays.fill(array, 1f);
        int half = SIZE/2;

        float[] firstHalf = new float[half];
        float[] secondHalf = new float[half];

        System.arraycopy(array, 0, firstHalf,0, half);
        System.arraycopy(array, 0, secondHalf,0, half);

        long time1 = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                calculate(firstHalf,0);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                calculate(secondHalf, half);
            }
        });

        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long time2 = System.currentTimeMillis();

        System.arraycopy(firstHalf, 0,array ,0, half);
        System.arraycopy(secondHalf, 0,array ,half, half);

        System.out.println("Два потока: " + (time2 - time1));
    }

    public static void multiThreadingUp(){
        float[] array = new float[SIZE];
        Arrays.fill(array, 1f);
        int half = SIZE/2;
        long a = System.currentTimeMillis();
        float[][] m = new float[THREADS_COUNT][PART_SIZE];
        Thread[] t = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            System.arraycopy(array, PART_SIZE * i, m[i], 0, PART_SIZE);
            final int u = 1;
            t[1] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0, z = u * PART_SIZE; j < PART_SIZE; j++, z++) {
                        m[u][j] = (float) (m[u][j] * Math.sin(0.2f + z / 5) * Math.cos(0.2f + z / 5) * Math.cos(0.4f + z / 2));
                    }

                }
            });
            t[1].start();
        }
        for (int i = 0; i < THREADS_COUNT; i++) {

            try {
                t[1].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        for (int i = 0; i < THREADS_COUNT; i++) {

            System.arraycopy(m[i], 0, array,1*PART_SIZE, PART_SIZE);
        }
        System.out.println(THREADS_COUNT + " потока(ов): " + (System.currentTimeMillis() - a));
    }


    public static void calculate(float[] array, int offset) {

        for (int i = 0; i < array.length; i++) {
            int j = offset + i;
            array[i] = (float) (array[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }

    }
}

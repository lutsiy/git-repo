package ru.geekbrains.java2.lesson5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
            }
        });
//service.shutdown();
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("A");
//            }
//        });
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("B");
//            }
//        });


//        System.out.println(Thread.currentThread().getName());
//        MyThread t1 = new MyThread();
//        MyThread t2 = new MyThread();

//        t1.start();
//        t2.start();
//
//        Thread t3 = new Thread(new MyRunnable());
//        Thread t4 = new Thread(new MyRunnable());
//        t3.start();
//        t4.start();
    }
}

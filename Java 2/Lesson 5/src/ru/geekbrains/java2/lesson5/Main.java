package ru.geekbrains.java2.lesson5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        //System.out.println(counter.value());
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    counter.inc();

//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    counter.dec();

//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.value());
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int time = 0;
//                while (true){
//                time++;
//
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(time);
//                }
//
//
//            }
//        });
//        t.setDaemon(true);
//        t.start();
//
//        Thread.sleep(5000);
//        System.out.println("end");



//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; i++) {
//                    System.out.println(i);
//                }
//            }
//        });
//
//        t.start();
//        try {
//            t.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("end");


        //
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("A");
//            }
//        });
//
//        t.start();
//        t.start();


//        ExecutorService service = Executors.newFixedThreadPool(10);
//        service.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("A");
//            }
//        });
//        service.shutdown();


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

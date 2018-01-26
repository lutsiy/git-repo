/**
 * Java 1. Home Work 1
 * @autor Ilya Lutsevich
 * @version dated Nov 21 2017
 */

package ru.geekbrains.Lesson_01;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean res;

        System.out.println("Выберите задание");
        System.out.println("1 - Создать пустой проект в IntelliJ IDEA и прописать метод main();");
        System.out.println("2 - Создать переменные всех пройденных типов данных, и инициализировать их значения");
        System.out.println("3 - Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где е a, b, c, d – входные параметры этого метода");
        System.out.println("4 - Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false");
        System.out.println("5 - Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.");
        System.out.println("6 - Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;");
        System.out.println("7 - Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;");
        System.out.println("8 - *Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й високосный");
        int task = scanner.nextInt();

        if (task == 1) {
            System.out.println("True :)");
        } else if (task == 2) {
            variables();
        } else if (task == 3) {
            System.out.println("Введите а: ");
            float a = scanner.nextInt();

            System.out.println("Введите b: ");
            float b = scanner.nextInt();

            System.out.println("Введите c: ");
            float c = scanner.nextInt();

            System.out.println("Введите d: ");
            float d = scanner.nextInt();

            calculate(a, b, c, d);

        } else if (task == 4) {
            System.out.println("Введите а: ");
            float a = scanner.nextInt();

            System.out.println("Введите b: ");
            float b = scanner.nextInt();

            res = between(a, b);
            System.out.println(res);

        } else if (task == 5) {
            System.out.println("Введите число: ");
            int a = scanner.nextInt();

            res = isPositiveOrNegative(a);
            if (res == true) {
                System.out.println("Отрицательное");
            } else {
                System.out.println("Положительное");
            }
        } else if (task == 6) {
            System.out.println("Введите число: ");
            int a = scanner.nextInt();

            res = isPositiveOrNegative(a);
            if (res == true) {
                System.out.println(res);
            } else {
                //System.out.println(res);
            }
        } else if (task == 7) {
            System.out.println("Введите имя: ");

            String a = new String();
            a = scanner.next();

            HelloUser(a);
        } else if (task == 8) {
            System.out.println("Введите год: ");
            int a = scanner.nextInt();
            leap_Year(a);
        } else {
            System.out.println("Введите число от 1 до 8! ");
        }


    }

    public static void variables() {
        byte a = 127;
        System.out.println("byte - " + a);

        short b = 32767;
        System.out.println("short - " + b);

        int c = 2147483647;
        System.out.println("int - " + c);

        long d = 9223372036854775807L;
        System.out.println("long - " + d);

        float e = 120.0f;
        System.out.println("float - " + e);

        double f = 15.72775;
        System.out.println("double - " + f);

        boolean g = true;
        System.out.println("bollean - " + g);

        char h = 'A';
        System.out.println("char - " + h);
    }

    public static void calculate(float a, float b, float c, float d) {

        float res;
        res = a * (b + (c / d));
        System.out.println("Резульат a * (b + (c / d)) = " + res);
    }

    public static boolean between(float a, float b) {
        float res;

        res = a + b;

        if (res >= 10 && res <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPositiveOrNegative(int a) {

        if (a >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void HelloUser(String a) {
        System.out.println("Привет " + a + "!");

    }
    
    public static void leap_Year(int a) {

        boolean leap = false;

        int res1 = a % 4;
        int res2 = a % 100;
        int res3 = a % 400;

        if (res1 == 0) {
           leap = true;
        }
        if (res2 == 0) {
            leap = false;
        }
        if (res3 == 0) {
            leap = true;
        }

        if (leap) {
            System.out.println(a + " год высокосный !");
        } else {
            System.out.println(a + " год не высокосный !");
        }

    }
}

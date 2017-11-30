/**
 * Java 1. Home Work 2
 * @author Ilya Lutsevich
 * @version dated Nov 27 2017
 */

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lesson_03 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int a;
        do {
            System.out.println("Game 1");
            System.out.println("//////");
            System.out.println("");
            game1();
            System.out.println("Repeat game? 1 - yes /0 - no");
            a = scanner.nextInt();
        }while (a == 1);


        System.out.println("Game 2");
        System.out.println("//////");
        System.out.println("");
        game2();
    }

    public static void game1() {

        //Загадаем случайное число от 1 до 9
        Random rand = new Random();
        int answer = 0;
        int x = rand.nextInt(10);
        String win = "";

        // Определим что у игорока 4 попытки
        for (int t = 1; t < 4; t++) {

            System.out.println("try " + t);
            answer = scanner.nextInt();

            if (answer == x) {//Победа
                System.out.println("True!!");
                win = "You Win!";
                break;
            } else if (answer > x) {//Загаданное число меньше
                System.out.println("less");
                win = "You Lose!";
            } else if (answer < x) {//Загаданное число меньше
                System.out.println("more");
                win = "You Lose!";
            }
        }
        System.out.println(win);
    }

    public static void game2() {

        String answer = "";
        int lengthArray = 0;
//Изменения
// Изменения2
// Первый вариант загрузки из файла через FileReader (имеет ли право на жизнь такой вариант?)
// Массив состоит из слов в одну строку, разделенных запятыми
//        // reading from file
//        //Определим длину массива (по умолчанию принимаем разделитель запятая код 44)
//        try {
//            int b;
//            FileReader file = new FileReader("Array.txt");
//            while ((b = file.read()) != -1)
//                if (b == 44){
//                    lengthArray ++;
//                }
//            file.close();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//
//        //Создадим массив
//        String[] words = new String[lengthArray + 1];
//
//        //Заполним массив по символьно (разделитель - запятая)
//        try {
//            int b;
//            int i = 0;
//            words[i] = "";
//            FileReader file = new FileReader("Array.txt");
//            while ((b = file.read()) != -1)
//                if (b == 44){
//                    i++;
//                    words[i] = "";
//                }else{
//                    words[i] = words[i] + (char)b;
//                }
//            System.out.print((char)b);
//            file.close();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        //System.out.println(Arrays.toString(words));

//Второй вариант загрузки из файла через поток
// Массив состоит множества строк, каждое слово в отдельной строке
        Path path = Paths.get("Array.txt");
        String[] words = new String[25];

        try (Stream<String> lines = Files.lines(path)) {
            //Создадим массив из потока
            words =  lines.toArray(String[]::new);
        } catch (IOException ex) {
            System.out.println("Файл не найден!");
        }

//        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
//                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
//                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        //Выберем случайное слово
        Random rand = new Random();
        int x = rand.nextInt(25);
        String hidden = words[x];
        String res = "";
        String h;
        String a;


        do {
            res = "";
            System.out.println("Guess the word:");
            answer = scanner.next();

            //Добавим решетки в ответ до длины 15 символов
            for(int j = answer.length(); j < 16; j ++){
                answer = answer + "#";
            }

            //Добавим решетки в загаданное слово до длины 15 символов
            for(int j = hidden.length(); j < 16; j ++){
                hidden = hidden + "#";
            }

            //Найдем совпадения в загаданном слове и ответе, не совпадающие символы заменим решеткой
            for (int i = 0; i < answer.length(); i++) {

                if (answer.charAt(i) == hidden.charAt(i)) {
                    res = res + answer.charAt(i);
                } else {
                    res = res + "#";
                }
            }
            System.out.println("res = " + res);

            //Уберем решетки из ответа и загаданого слова для сравнения
            h = hidden.replace("#","");
            a = answer.replace("#","");}

        // повторяем до тех пор пока загаданное слово и ответ не совпадут
        while (!a.contains(h));

        System.out.println("hidden word = " + res.replace("#",""));
        System.out.println("You WIN!");
    }
}

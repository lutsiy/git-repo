package Lesson_05;

/**
 * Java 1. Home Work 5
 * @author Ilya Lutsevich
 * @version dated Dec 08 2017
 * @link https://github.com/lutsiy/git-repo.git
 */

/*      1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;

        2. Конструктор класса должен заполнять эти поля при создании объекта;

        3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;

        4. Создать массив из 5 сотрудников

        Пример:
        Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
        persArray[1] = new Person(...);
        ...
        persArray[4] = new Person(...);

        5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;

        6. *** Используя код крестиков-ноликов из материалов занятия №4, переписать их с использованием объектно-ориентированного подхода (разбить на объекты);*/




import java.util.*;

public class Lesson_05 {

    Random rand = new Random();
    public static void main(String[] args) {
        final char DOT_X = 'x';
        final char DOT_O = 'o';
        final int SIZE = 3;
        char[][] map = new char[SIZE][SIZE];
        final int NUMBER_TO_WIN = 3;
        //Задание 1 - 5
        //Объявим массив объектов
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan",        "Engineer",                 "Engineer@company.com",     "892312312",    30000, 40);
        persArray[1] = new Person("Petrov Petr",        "Director",                 "Director@company.com",     "892312312",    30000, 50);
        persArray[2] = new Person("Sidorov Ivan",       "Accountant",               "Accountant@company.com",   "892312312",    30000, 60);
        persArray[3] = new Person("Nikolaev Nicholas",  "Java Developer",           "Programmer@company.com",   "892312312",    30000, 36);
        persArray[4] = new Person("Lutsevich Ilya",     "Junior Java Developer",    "lutsiy@inbox.ru",          "89139273124",  40000, 36);

        for (int num = 0; num < persArray.length; num++){

            if (persArray[num].age >= 40) {
                persArray[num].getinfo();
                System.out.println("\n////////////\n");
            }
        }

        //Задание 6
        Human human = new Human(DOT_X, DOT_O);
        AI ai = new AI(DOT_O, DOT_X);
        Game game = new Game(SIZE);
        game.initMap(map);
        game.printMap(map);
        while (true) {
            human.humanTurn(map);
            game.printMap(map);
            if (game.checkWin(map, DOT_X, NUMBER_TO_WIN)) {
                System.out.println("YOU WON!");
                break;
            }
            if (game.isMapFull(map)) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            ai.aiTurn(map, DOT_O, DOT_X, NUMBER_TO_WIN);
            game.printMap(map);
            if (game.checkWin(map, DOT_O, NUMBER_TO_WIN)) {
                System.out.println("AI WON!");
                break;
            }
        }
        System.out.println("GAME OVER.");
    }
}
class Person{
    String surname;
    String position;
    String email;
    String phone;
    int salary;
    int age;

    public Person(String surname, String position, String email, String phone, int salary, int age) {
        this.surname = surname;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void getinfo(){

        System.out.println("Еmployee surname: "   + this.surname +
                "\nposition: "         + this.position +
                "\ne-mail: "           + this.email +
                "\nphone: "            + this.phone +
                "\nsalary: "           + this.salary +
                "\nage: "              + this.age);
    }
}
class Human {
    Scanner sc = new Scanner(System.in);
    char dot;
    char dot_enemy;

    public Human(char dot, char dot_enemy) {
        this.dot = dot;
        this.dot_enemy = dot_enemy;
    }

    public void humanTurn(char map[][]) {
        int x, y;
        do {
            System.out.println("Enter X and Y (1..3):");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y, map));
        map[y][x] = dot;
    }
    boolean isCellValid(int x, int y, char map[][]) {
        if (x < 0 || y < 0 || x >= map.length || y >= map.length)
            return false;
        if (map[y][x] == dot_enemy)
            return false;
        return true;
    }
}
class AI{
    Random rand = new Random();
    char dot;
    char dot_enemy;
    final char dot_empty = '.';

    public AI(char dot, char dot_enemy) {
        this.dot = dot;
        this.dot_enemy = dot_enemy;
    }

    void aiTurn(char map[][], char dot, char dot_enemy, int number_to_win) {
        int x, y;
        int i;
        int j = 0;
        int win = 0;
        int aii = 0;
        int aij = 0;
        //Проверим главную дагональ, есть ли у игрока есть 2 установленных крестика
        for (i = 0; i < map.length; i++) {
            for (j = 0; j < map.length; j++) {
                if (i == j) {
                    if (map[i][j] == dot_enemy){
                        win = win + 1;
                        aii = i + 1;
                        aij = j + 1;
                        if(aii >= map.length){
                            aii = aii - map.length;
                        }
                        if (aij >= map.length){
                            aij = aij - map.length;
                        }
                    }
                }
            }
        }

        // Если есть два крестика , заблокируем
        if (win == number_to_win - 1){
            if (isCellValid(aij, aii, map)) {
                map[aii][aij] = dot;
                return;
            }
        } else {
            win = 0;
        }

        //Проверим вторую дагональ, есть ли у игрока есть 2 установленных крестика
        for (i = map.length - 1, j = 0; i >= 0; i--, j++) {

            if (map[i][j] == dot_enemy){
                win = win + 1;
                aii = i - 1;
                aij = j + 1;
                if(aii < 0){
                    aii = aii + map.length;
                }
                if (aij >= map.length){
                    aij = aij - map.length;
                }
            }
        }

        // Если есть два крестика , заблокируем
        if (win == number_to_win - 1){
            if (isCellValid(aij, aii, map)) {
                map[aii][aij] = dot;
                return;
            }
        } else {
            win = 0;
        }

        //Проверим горизонтали, есть ли у игрока есть 2 установленных крестика
        for (i = 0; i < map.length ; i++) {
            for (j = 0; j < map.length; j++) {
                if (map[i][j] == dot_enemy) {
                    win = win + 1;
                    aii = i;
                    aij = j + 1;
                    if(aii >= map.length){
                        aii = aii - map.length;
                    }
                    if (aij >= map.length){
                        aij = aij - map.length;
                    }
                }
            }
            // Если есть два крестика , заблокируем
            if (win == number_to_win - 1) {
                if (isCellValid(aij, aii, map)) {
                    map[aii][aij] = dot;
                    return;
                }
            } else {
                win = 0;
            }
        }

        //Проверим вертикали, есть ли у игрока есть 2 установленных крестика
        for (j = 0; j < map.length ; j++) {
            for (i = 0; i < map.length; i++) {
                if (map[i][j] == dot_enemy) {
                    win = win + 1;
                    aii = i + 1;
                    aij = j;
                }
                if(aii >= map.length){
                    aii = aii - map.length;
                }
                if (aij >= map.length){
                    aij = aij - map.length;
                }
            }
            // Если есть два крестика , заблокируем
            if (win == number_to_win - 1) {
                if (isCellValid(aij, aii, map)) {
                    map[aii][aij] = dot;
                    return;
                }
            } else {
                win = 0;
            }
        }
        //Если перечисленные ситуации не выполнились, установим нолик стандартно, через rand()
        do {
            x = rand.nextInt(map.length);
            y = rand.nextInt(map.length);
        } while (!isCellValid(x, y, map));
        map[y][x] = dot;}

    boolean isCellValid(int x, int y, char map[][]) {
        if (x < 0 || y < 0 || x >= map.length || y >= map.length)
            return false;
        if (map[y][x] == dot_enemy)
            return false;
        return true;
    }

}
class Game{
    final char DOT_EMPTY = '.';
    private int size;

    public Game(int size) {
        this.size = size;
    }
    void initMap(char[][] map) {
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map.length; j++)
                map[i][j] = DOT_EMPTY;
    }

    boolean isMapFull(char[][] map) {
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map.length; j++)
                if (map[i][j] == DOT_EMPTY)
                    return false;
        return true;
    }

    void printMap(char map[][]) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public boolean checkWin(char[][] map, char dot, int number_to_win) {
        // Необходимо уточнить, что для поля 5х5 не рассмотрел вариант выигрыша, когда 4 фишки
        // установлены не на главной либо второй диагонали

        int win = 0;
        //Проверим главную дагональ
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (i == j) {
                    if (map[i][j] == dot){
                        win = win + 1;
                    }
                }
            }
        }

        // Проверим, есть ли выигрышная комбинация
        if (win == number_to_win){
            return true;
        } else {
            win = 0;
        }

        //Проверим вторую дагональ
        for (int i = map.length - 1, j = 0; i >= 0; i--, j++) {

            if (map[i][j] == dot){
                win = win + 1;
            }
        }

        // Проверим, есть ли выигрышная комбинация
        if (win == number_to_win){
            return true;
        } else {
            win = 0;
        }

        //Проверим горизонтали
        for (int i = 0; i < map.length ; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == dot) {
                    win = win + 1;
                }
            }
            if (win == number_to_win) {
                return true;
            } else {
                win = 0;
            }
        }

        //Проверим вертикали
        for (int i = 0; i < map.length ; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[j][i] == dot) {
                    win = win + 1;
                }
            }
            if (win == number_to_win) {
                return true;
            } else {
                win = 0;
            }
        }
        return false;
    }



}


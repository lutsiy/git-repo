package Lesson_07;

/**
 * Java 1. Home Work 7
 * @author Ilya Lutsevich
 * @version dated Dec 15 2017
 * @link https://github.com/lutsiy/git-repo.git
 */

/*
1. Расширить задачу про котов и тарелки с едой
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true
4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
*/

import java.util.*;

public class Lesson_07 {

    public static void main(String[] args) {
        int app;
        Cat[] cat = new Cat[10];
        Plate plate = new Plate(5);

        System.out.println(plate);
        plate.increaseFood(20);
        System.out.println(plate);

        for (int i = 0; i<10; i++){
            Random rand = new Random();
            app = rand.nextInt(10) + 1;
            cat[i] = new Cat("cat " + (i+1), app);
        }

        for (int i = 0;i < 10; i++) {
            if (plate.balance(cat[i]) >= 0) {
                cat[i].eat(plate);
                System.out.println(cat[i].name + " eat " + cat[i].appetite + " (full = " + cat[i].full + ")");
            } else {
                System.out.println(cat[i].name + " eat " + cat[i].appetite + " (not enough food!)" + " full = " + cat[i].full);
            }
            System.out.println(plate);
        }
    }
}

class Cat {
    String name;
    int appetite;
    boolean full;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    void eat(Plate plate) {
        plate.decreaseFood(appetite);
        this.full = true;
    }
}

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    void decreaseFood(int food) {
        this.food -= food;
    }

    void increaseFood(int food) {
        this.food += food;
    }

    int balance(Cat cat){
        return this.food - cat.appetite;
    }

    @Override
    public String toString() {
        return "Plate: " + food;
    }

}
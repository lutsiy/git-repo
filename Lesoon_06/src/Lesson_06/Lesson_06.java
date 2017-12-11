package Lesson_06;

/**
 * Java 1. Home Work 6
 * @author Ilya Lutsevich
 * @version dated Dec 11 2017
 * @link https://github.com/lutsiy/git-repo.git
 */

/*
1. Создать классы Собака и Кот с наследованием от класса Животное.

        2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).

        3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).

        4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true)
*/

public class Lesson_06 {

    public static void main(String[] args) {

        double rundist = 250.0d;
        double swimdist = 9.0d;
        double jumphigh = 1.0d;

        Dog dog = new Dog("Sharik");
        Cat cat = new Cat("Barsik");

        System.out.println(dog.name + " run for " + rundist + " m.: " + dog.run(rundist));
        System.out.println(dog.name + " swim for " + swimdist + " m.: " + dog.swim(swimdist));
        System.out.println(dog.name + " jump for " + jumphigh + " m.: " + dog.jump(jumphigh));

        System.out.println(cat.name + " run for " + rundist + " m.: " + cat.run(rundist));
        System.out.println(cat.name + " jump for " + jumphigh + " m.: " + cat.jump(jumphigh));


    }
}

interface IAnimal {
    String voice();
    boolean run(double dist);
    boolean jump(double high);
}

abstract class Animal implements IAnimal {
    String name;

    Animal(String name) {
        this.name = name;
    }
}

class Cat extends Animal {

    double dist;

    Cat(String name) {
        super(name);
    }
    public String voice() {
        return "meow";
    }
    public boolean run (double dist){
        if (dist >= 200.0d || dist <= 0.0d){
            return false;
        } else {
            return true;
        }
    }
    public boolean jump (double high){
        if (high >= 2.0d || high <= 0.0d){
            return false;
        } else {
            return true;
        }
    }

}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
    public String voice() {
        return "gau-gau";
    }

    public boolean run (double dist){
        if (dist >= 500.0d || dist <= 0.0d){
            return false;
        } else {
            return true;
        }
    }
    public boolean jump (double high){
        if (high >= 0.5d || high <= 0.0d){
            return false;
        } else {
            return true;
        }
    }
    public boolean swim (double dist){
        if (dist >= 10.0d || dist <= 0.0d){
            return false;
        } else {
            return true;
        }
    }
}




/*
Создать абстрактный класс Animal с характеристиками животного.
Создать класс Horse который наследуется от Animal, в классе Horse реализовать метод public void run(){ System.out.println("Игого, я поскакал(а)"); }
Создать класс Pegasus который наследуется от Horse, в классе Pegasus реализовать метод public void fly(){ System.out.println("Игого, я полетел(а)"); }
Создать объект лошади и вызвать метод run();
Создать объект пегаса и вызвать метод fly();
*/

public class Main{
    public static void main(String[] args) {
        //Ваш код
        Horse horse = new Horse("Буцефал","Домашнее","Травоядное",230);
        horse.run();
        Pegasus pegas = new Pegasus("Пегас","Дикое","травоядное",170);
        pegas.fly();

    }
}
abstract class Animal{
    String name;
    String Lifestyle;
    String foodType;
    int weight;

    public Animal(String name, String lifestyle, String foodType, int weight) {
        this.name = name;
        Lifestyle = lifestyle;
        this.foodType = foodType;
        this.weight = weight;
    }

}

class Horse extends Animal {
    public Horse(String name, String lifestyle, String foodType, int weight) {
        super(name, lifestyle, foodType, weight);
    }
    public void run() {System.out.println("Игого, я поскакал(а)");}
}

class Pegasus extends Horse {
    public Pegasus(String name, String lifestyle, String foodType, int weight) {
        super(name, lifestyle, foodType, weight);
    }
    public void fly(){ System.out.println("Игого, я полетел(а)");}
}

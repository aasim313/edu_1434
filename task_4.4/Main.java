/*
Создай классы Dog, Cat, Mouse.
Добавь по три поля в каждый класс, на твой выбор.
Создай объекты для героев мультика Том и Джерри.
Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse("Jerry", 12 , 5),
где 12 - высота в см,
5 - длина хвоста в см.
Требования:
•	Создай класс Dog.
•	Создай класс Cat.
•	В классе Dog должно быть три переменные.
•	В классе Cat должно быть три переменные.
•	Должен быть создан хотя бы один объект типа Mouse.
•	Должен быть создан хотя бы один объект типа Dog.
•	Должен быть создан хотя бы один объект типа Cat.
*/

public class Main {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);

        //напишите тут ваш код
        Dog spikeDog  =new Dog("Спайк",30,true);
        Cat tomCat = new Cat("Том","Grey",true);


    }
}
class Mouse {
    String name;
    int height;
    int tail;

    public Mouse(String name, int height, int tail) {
        this.name = name;
        this.height = height;
        this.tail = tail;
    }
}
class Dog {
    String name;
    int weight;
    boolean sleepStatus;

    public Dog(String name, int weight, boolean sleepStatus) {
        this.name = name;
        this.weight = weight;
        this.sleepStatus = sleepStatus;
    }
}

class Cat {
    String name;
    String color;
    boolean hungerStatus;

    public Cat(String name, String color, boolean hungerStatus) {
        this.name = name;
        this.color = color;
        this.hungerStatus = hungerStatus;
    }
}

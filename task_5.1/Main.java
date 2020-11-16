/*
* Дана коллекция имён.
* 1) удалить все повторяющиеся имена из коллекции
* 2) вывести коллекцию на экран
* */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList();
        names.add("Анатолий");
        names.add("Георгий");
        names.add("Руслан");
        names.add("Георгий");
        names.add("Павел");
        names.add("Руслан");
        // решение

         // System.out.println("Задана коллекция: " + names);
        for (int i = 0; i < names.size()-1; i++) {
             // System.out.print(names.get(i) + ": ");
            for (int j = i+1; j < names.size(); j++) {
                if (names.get(i).equals(names.get(j))) names.remove(j);
            }
             // System.out.println(names);
        }
    }
}

/*
* Задание: Дана коллекция с числами. Запишите в новую коллекцию только те числа, которые больше нуля и меньше 10-ти.
* Коллекции вы создаёте сами
*/
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("ведите числа, которые больше нуля и меньше 10-ти  : ");

        while (true) {
            try {
                int input = scan.nextInt();
                if (0 < input && input < 10) {
                    numList.add(input);
                    System.out.println(numList);
                } else System.out.println(" число не входит в диапазон от 1 до 9");
            } catch (InputMismatchException e) {
                System.out.println(numList);
                break;
            }

        }
    }
}

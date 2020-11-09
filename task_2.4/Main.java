/*
Задание: Пользователь вводит сумму вклада и процент, который будет начисляться ежегодно. Отобразить размер вклада поочередно на ближайшие 5 лет.
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scan = new Scanner(System.in);
        System.out.print("Сумма вклада: ");
        double deposit = scan.nextDouble();
        System.out.print("Процен вклада: ");
        double percent = scan.nextDouble();

        for (int i = 0; i < 6; i++) {
            deposit*=(1.0+percent*0.01);
            System.out.println(i + "-й год: Депозит = " + deposit);

        }

    }

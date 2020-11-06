/*
Пользователь вводит число, необходимо увеличить это число на 15% и вывести результат на экран
*/
import java.util.Scanner;  // подключение класса Scanner
public class Main {
    public static void main(String[] args) {
        // Ваш код
        Scanner scan = new Scanner(System.in);
        float number100 = scan.nextInt();
        float number115 = (float) 1.15 * number100;
        System.out.println("115 % от введенного числа: " + number115);
    }
}

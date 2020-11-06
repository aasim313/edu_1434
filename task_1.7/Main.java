/* Задача наполнить корабельный бассейн. Нужно посчитать, сколько литров воды нужно для заполнения бассейна до бортов.
Известно, что бассейн имеет линейные размеры a × b × c, заданные в метрах.
Эти размеры передаются запрашиваются у пользователя. Прграмма должена вывести на экран количество литров воды,
которое нужно для наполнения бассейна.
Пример:
Пользователь даёт числа 25, 5, 2.
Пример вывода:
250000 */


import java.util.Scanner;  // подключение класса Scanner
public class Main {
    public static void main(String[] args) {
        //Ваш код
        Scanner scan = new Scanner(System.in);
        System.out.println("введите длину бассейна (м): ");
        float a = scan.nextInt() * (float) 10.0;
        System.out.println("введите ширину бассейна (м): ");
        float b = scan.nextInt() * (float) 10.0;;
        System.out.println("введите глубину бассейна (м): ");
        float c = scan.nextInt() * (float) 10.0;;
        float v = a*b*c;

        System.out.println("Объем бассейна: " + v + "литров" );
    }
}

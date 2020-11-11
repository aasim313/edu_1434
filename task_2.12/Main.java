/*
ВНИМАНИЕ эта задача для ДЗ и не является обязательной.
Задание: 1. Создай массив чисел.
2. Добавь в массив 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.
Пример для списка 2, 4, 4, 4, 8, 8, 4, 12, 12, 14:
3
*/

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scan = new Scanner(System.in);
        int arr[] = new int[10];            // 1 .

        for (int i = 0; i < 10; i++) {      // 2.
            System.out.print("введите элемент "+i+" :");
            arr[i] = scan.nextInt();

        }
        int lengthNew = 1;
        int lengthMax = 1;
        for (int i = 1; i < 10; i++) {
            if (arr[i-1] == arr[i]) lengthNew++;
            else if (lengthNew != lengthMax) {
                lengthMax = lengthNew;
                lengthNew = 1;
            }
            else  lengthNew = 1;


        }
        System.out.println(" Max колличество элементов в последовательности: " + lengthMax);



    }
}

/*
Задание: Дан массив с числами. Проверьте, есть ли в нем два одинаковых числа подряд. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/

public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        int arr[] = {1, 2, 3, 4, 5, 6, 1, 8, 3};
        boolean flag = false;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) flag = true;
            }
        }
            if (flag) System.out.println("да");
            else System.out.println("нет");


    }
}

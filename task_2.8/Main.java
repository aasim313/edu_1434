/*
Задание: Дан массив с элементами [2, 3, 4, 5]. С помощью цикла for найдите произведение элементов этого массива.
*/

public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        int arr[] = {2,3,4,5};
        int multArr = 1;
        for (int i = 0; i < arr.length; i++) {
            multArr*=arr[i];
        }
        System.out.println("Произведение элементов массива равно: " + multArr);

    }
}

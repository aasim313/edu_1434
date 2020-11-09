/*
Задание: Дан массив с числами. Узнайте сколько элементов с начала массива надо сложить, чтобы в сумме получилось больше 10-ти.
*/

public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        int arr[] = {1,2,3,4,5,6,7,8,9};
        int sum = 00;
        int i = 0;

        while (sum<=10) {
        sum+= arr[i];
        i++;
        }
        System.out.println(i);
    }
}

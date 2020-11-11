/*
Задание: Дан массив с числами. Выведите последовательно его элементы используя рекурсию и не используя цикл.
*/


public class Main {
    public static void main(String[] args) {
        int num[] = {4, 2, 6, 2, 65};
        printArr(num, 0);
    }

    public static void printArr(int[] numbers, int i) {
        System.out.print(numbers[i] + " " );
        if (i < numbers.length-1) printArr (numbers, ++i);
        }
}

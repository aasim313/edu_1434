/*
Задание: Дан массив с числами. Проверьте, что в этом массиве есть число 5. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/

public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        int arr[] = {1,2,4,6,2,0,3,5};
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==5) flag = true;
        }
        if (flag) System.out.println("да");
             else System.out.println("нет"); ;

    }
}

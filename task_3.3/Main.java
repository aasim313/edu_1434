/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа. Если эти числа равны - пусть функция вернет true, а если не равны - false.
*/


public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
     System.out.println(checkEquality(2,2)); // проверка

    }
    public static boolean checkEquality (int a, int b) {
        if (a == b ) return true;
        else return false;
    }    
    
}

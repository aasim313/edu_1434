  
/* 
1. Ввести путь к файлу с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
-2
11
3
-5
2
10
Пример вывода:
-2
2
8
10
*/


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
// Получение из консоли пути к файлу
        Scanner scanConsole = new Scanner(System.in);
        System.out.print("Введите путь к файлу:");
        String link = scanConsole.nextLine();
        FileReader fileReader  = new FileReader(link);
//считывание из файла
        Scanner scanFileReader = new Scanner(fileReader);
        ArrayList<Integer> arrayList = new ArrayList<>();
        String nextLine="";
        int nextInt;

        while (scanFileReader.hasNextLine()){
            nextLine = scanFileReader.nextLine();
            nextInt=Integer.parseInt(nextLine) ;
           if (nextInt % 2 == 0 ) arrayList.add(nextInt);
        }
        fileReader.close();
//сортировка коллекции и вывод в консоль
        Collections.sort(arrayList);
        System.out.println(arrayList);
    }
}

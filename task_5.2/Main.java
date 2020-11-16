/*
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи
Лондон
Пример вывода:
Абрамовичи */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Модернизация ПО
*/

public class Main {
    public static void main(String[] args) {
        List <String> familyList = new ArrayList<>();
        List <String> sityList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("введите фамилии (по завершении нажмите Enter)");
        while (true) {
            System.out.print("фамилия " + (int) (familyList.size()+1) + " :");
            String family = scanner.nextLine();
            if (family.isEmpty()) break;
            else  if (familyList.indexOf(family)!=-1) System.out.println(family + " уже есть в списке, введите другую фамилию");
            else familyList.add(family);
        }

        System.out.println("введите Города (по завершении нажмите Enter) \n");
        while (sityList.size() < familyList.size()) {
            System.out.print("город " + (int) (sityList.size()+1) +"/" + (int) (familyList.size()+1) + " :");
            String sity = scanner.nextLine();
            if (sity.isEmpty()) System.out.println("городов меньше семей, нелюходимо ввести еще " +(int)(familyList.size()-sityList.size()) + " готдода(ов)");
            else sityList.add(sity);
        }

        
        System.out.println("Введите фамилию из списка: " + familyList);
        String family = scanner.nextLine();
        int index = familyList.indexOf(family);
        if (index!=-1) System.out.println(family + ": город " + sityList.get(index));
        else System.out.println("нет такой фамилии");

    }
}

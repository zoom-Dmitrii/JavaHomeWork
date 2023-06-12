package lesson5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class task5_1 {

    private static void printMenu() {
        System.out.println("-------------------------------------------------");
        System.out.println("Работа с телефонным справочником.");
        System.out.println("Введите номер меню:");
        System.out.println("1 - Добавление номера.");
        System.out.println("2 - Вывод телефонного справочника.");
        System.out.println("0 - Для выхода из любого пункта меню или завершения работы приложения");
        System.out.println("-------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String familyInput;
        String numberInput;
        HashMap<String, Set<String>> telephoneDirectory = new HashMap<>();
        Set<String> number = new HashSet<>();
        printMenu(); // Вызов меню выбора действий
        String userInput = scanner.nextLine(); // userInput сохраняет пользовательский ввод
        while (!userInput.equals("0")) { // Пока ввод не содержит 0 - ноль
            if (userInput.equals("1")) { // Ввели 1
                familyInput = "";
                numberInput = "";
                System.out.println("Введите фамилию");
                familyInput = scanner.nextLine();
                /*
                 * Сначала проверка на наличие фамилии в списке. Если есть,
                 * то считываем телефоны в список Set и добавляем новый
                 * Обнавляем значение для ключа Фамилия
                 */
                if (telephoneDirectory.containsKey(familyInput)) {
                    number = telephoneDirectory.get(familyInput);
                    System.out.println("Введите номер");
                    numberInput = scanner.nextLine();
                    number.add(numberInput);
                    telephoneDirectory.put(familyInput, number);
                } else {
                    /*
                     * Если фамилия новая, запрос номера телефона и добавляем новую запись: фамилия
                     * : телефон
                     */
                    number = new HashSet<>();
                    System.out.println("Введите номер");
                    numberInput = scanner.nextLine();
                    number.add(numberInput);
                    telephoneDirectory.put(familyInput, number);
                }
            } else if (userInput.equals("2")) { // Ввели 2. Вывод списка HashMap
                for (String family : telephoneDirectory.keySet()) {
                    String key = family;
                    String value = telephoneDirectory.get(family).toString();
                    System.out.println(key + " " + value);
                }
            } else // Если ввели значения пункта меню не из предложенных, вывод ошибки и заново
                System.out.println("Такого пункта меню нет, сделайте выбор из трех пунктов:");
            printMenu();
            userInput = scanner.nextLine();
        }
        System.out.println("Программа завершена");
    }
}

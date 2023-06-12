/*
Для ввода готовых параметров
15 Noutbook IBM Next 1500, AMD X8, 16, SDD, 500, Windows, Blue
17 Noutbook Asus New ver4.3, AMD Ryzen 5, 8, SDD, 250, Lnux, Red
15 ASUS TUF Gaming A15, AMD Ryxen 9, 16, SDD, 500, Linux, Green
 */

package lesson6;

import java.util.ArrayList;
import java.util.Scanner;

public class task6_1 {

    private static void printMenu() {
        System.out.println("-------------------------------------------------");
        System.out.println("Работа с базой.");
        System.out.println("Введите номер меню:");
        System.out.println("1 - Добавление нового ноутбука");
        System.out.println("2 - Подбор ноутбука по параметрам");
        System.out.println("3 - Вывод всей базы");
        System.out.println("0 - Для завершения работы приложения");
        System.out.println("-------------------------------------------------");
    }

    private static void printMenuSelect() {
        System.out.println("-------------------------------------------------");
        System.out.println("Выбор ноутбуков по параметрам.");
        System.out.println("Выберите параметр для поиска:");
        System.out.println("1 - Процессор");
        System.out.println("2 - ОЗУ от ... Gb");
        System.out.println("3 - Тип Накопителя (SDD или HDD)");
        System.out.println("4 - Объем накопителя от  ... Gb");
        System.out.println("5 - Тип OS");
        System.out.println("0 - Возврат в предыдущее меню");
        System.out.println("-------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Noutbook> noutbookList = new ArrayList<>();
        Noutbook noutbook1 = new Noutbook("15.6 Ноутбук Tecno Megabook T1",
                "Intel Core i5", 8, "SSD", 500, "Windows", "Black");
        Noutbook noutbook2 = new Noutbook("15.6 Ноутбук MSI Modern 15",
                "Intel Core i7", 16, "SSD", 1000, "Windows", "Silver");
        Noutbook noutbook3 = new Noutbook("15.6 Ноутбук Digma Pro Sprint M",
                "Intel Core i3", 4, "HDD", 250, "Linux", "White");
        Noutbook noutbook4 = new Noutbook("17.3 Ноутбук IRBIS 17NBP4500",
                "Intel Core i7", 32, "HDD", 1000, "Windows", "Metall-Black");
        Noutbook noutbook5 = new Noutbook("14 Ноутбук Infinix InBook X2 XL23",
                "Intel Core i5", 4, "SSD", 500, "Linux", "Red-Yellow");

        noutbookList.add(noutbook1);
        noutbookList.add(noutbook2);
        noutbookList.add(noutbook3);
        noutbookList.add(noutbook4);
        noutbookList.add(noutbook5);

        outputBase(noutbookList);
        System.out.println("Выберите действие:");

        printMenu(); // Вызов меню выбора действий
        String userInput = scanner.nextLine(); // userInput сохраняет пользовательский ввод
        while (!userInput.equals("0")) { // Пока ввод не содержит 0 - ноль
            if (userInput.equals("1")) { // Ввели 1
                System.out.println("Введите пармаетры ноутбука, через запятую.\n"
                        + "Нужно ввести: Название, модель процессора, объем оперативной памяти в Gb (цифру),\n"
                        + "тип накопителя, объем накопителя в Gb (цифру), тип операционной системы, цвет");
                System.out.println();
                String[] splitLine = splitterInput(scanner.nextLine());
                noutbookList.add(new Noutbook(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2]), splitLine[3],
                        Integer.parseInt(splitLine[4]), splitLine[5], splitLine[6]));
            } else if (userInput.equals("2")) { // Ввели 2. Работа по параметрам
                printMenuSelect();
                userInput = scanner.nextLine(); // userInput сохраняет пользовательский ввод
                while (!userInput.equals("0")) {
                    System.out.print("Введите параметр для поиска: ");
                    if (userInput.equals("1")) {
                        findNoutbook(1, scanner.nextLine(), noutbookList);
                    } else if (userInput.equals("2")) {
                        findNoutbook(2, scanner.nextLine(), noutbookList);
                    } else if (userInput.equals("3")) {
                        findNoutbook(3, scanner.nextLine(), noutbookList);
                    } else if (userInput.equals("4")) {
                        findNoutbook(4, scanner.nextLine(), noutbookList);
                    } else if (userInput.equals("5")) {
                        findNoutbook(5, scanner.nextLine(), noutbookList);
                    } else if (userInput.equals("6")) {
                        findNoutbook(6, scanner.nextLine(), noutbookList);
                    } else if (userInput.equals("0")) {
                        break;
                    } else // Если ввели значения пункта меню не из предложенных, вывод ошибки и заново
                        System.out.println("Такого пункта меню нет, сделайте выбор из трех пунктов:");
                    printMenuSelect();
                    userInput = scanner.nextLine();
                }
            } else if (userInput.equals("3")) { // Ввели 3. Вывод всего списка
                outputBase(noutbookList);
            } else // Если ввели значения пункта меню не из предложенных, вывод ошибки и заново
                System.out.println("Такого пункта меню нет, сделайте выбор из трех пунктов:");
            printMenu();
            userInput = scanner.nextLine();
        }

        System.out.println("Программа завершена");

    }

    private static void findNoutbook(Integer index, String textInput, ArrayList<Noutbook> noutbookList) {
        int i = 1;
        boolean findeData = false;
        switch (index) {
            case (1):
                for (Noutbook noutbook : noutbookList) {
                    if (noutbook.getProcessor().toLowerCase().contains(textInput.toLowerCase())) {
                        System.out.println(i + ": " + noutbook);
                        findeData = true;
                        i++;
                    }
                }
                if (findeData == false)
                    System.out.println("Нет подходящих позиций");
                break;
            case (2):
                for (Noutbook noutbook : noutbookList) {
                    if (noutbook.getRam() >= Integer.parseInt(textInput)) {
                        System.out.println(i + ": " + noutbook);
                        findeData = true;
                        i++;
                    }
                }
                if (findeData == false)
                    System.out.println("Нет подходящих позиций");
                break;
            case (3):
                for (Noutbook noutbook : noutbookList) {
                    if (noutbook.getTypeHdd().toLowerCase().contains(textInput.toLowerCase())) {
                        System.out.println(i + ": " + noutbook);
                        findeData = true;
                        i++;
                    }
                }
                if (findeData == false)
                    System.out.println("Нет подходящих позиций");
                break;
            case (4):
                for (Noutbook noutbook : noutbookList) {
                    if (noutbook.getHdd() >= Integer.parseInt(textInput)) {
                        System.out.println(i + ": " + noutbook);
                        findeData = true;
                        i++;
                    }
                }
                if (findeData == false)
                    System.out.println("Нет подходящих позиций");
                break;
            case (5):
                for (Noutbook noutbook : noutbookList) {
                    if (noutbook.getOs().toLowerCase().contains(textInput.toLowerCase())) {
                        System.out.println(i + ": " + noutbook);
                        findeData = true;
                        i++;
                    }
                }
                if (findeData == false)
                    System.out.println("Нет подходящих позиций");
                break;
        }

    }

    private static void outputBase(ArrayList<Noutbook> noutbookList) {
        System.out.println();
        System.out.println("В наличии есть ноутбуки:");
        int i = 1;
        for (Noutbook noutbook : noutbookList) {
            System.out.println(i + ": " + noutbook);
            i++;
        }
        System.out.println();
    }

    private static String[] splitterInput(String nextLine) {
        String[] newLine = nextLine.split(", ");
        return newLine;
    }
}

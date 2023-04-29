// В калькулятор добавьте возможность отменить последнюю операцию.

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class task4_3 {
    private static Deque<String> deque = new ArrayDeque<>();

    private static String process(String el) { // Достаем значения из списка и отправляем в калькулятор
        try {
            if (deque.size() == 0) { // Далее после первого элемента возвращаем результат операции
                return el;
            }
            if (el.equals("<") && deque.size() == 1) { // отмена максимум до первого числа
                return deque.peekLast();
            }
            if (el.equals("<")) { // если значений много, можно отменять
                deque.pollLast();
                return deque.peekLast();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } // отправка данных для подсчета. Взяли и удалили знак операции, взяли последний
          // результат и новое число
        return calc(deque.pollLast(), Float.parseFloat(deque.peekLast()), Float.parseFloat(el));
    }

    private static String calc(String operator, Float num1, Float num2) {

        switch (operator) {
            case "*":
                return Float.toString(num1 * num2);
            case "/": {
                if (num2 == 0)
                    return "Делить на 0 нельзя";
                else
                    return Float.toString(num1 / num2);
            }
            case "+":
                return Float.toString(num1 + num2);
            case "-":
                return Float.toString(num1 - num2);
        }
        return "Что-то пошло не так";
    }

    private static void addEl(String el) {
        deque.add(el);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // LinkedList<String> inLine = new LinkedList<>();
        System.out.println("Калькулятор");
        System.out.println("Вводите цифры и операции через Enter. Для окончания введите: st ");
        System.out.println("Для отмены последней операции введите < (знак меньше)");
        String elTemp = null; // вводимые цифры и операции
        Boolean token = false; // ожидаем знак
        elTemp = scanner.nextLine();
        while (!elTemp.equals("st")) { // выполняем до команды st
            if (!elTemp.equals("<")) { // проверка на команду отмены
                if (token) {
                    while (!"+-*/".contains(elTemp)) { // Должны ввести знак операции
                        System.out.println("Введите оператор");
                        elTemp = scanner.nextLine();
                    }
                    token = false; // переключили, теперь ждем число
                    addEl(elTemp); // записали знак
                    elTemp = scanner.nextLine();
                } else {
                    token = true; // переключили, теперь ждем знак
                    addEl(process(elTemp)); // число на процедуры и в список
                    if (deque.size() > 1) {
                        System.out.printf("Ответ: %s", deque.peekLast()); // вывод ответа после первой операции
                        System.out.println();
                    }
                    elTemp = scanner.nextLine();
                }

            } else {
                System.out.printf("Отмена: < Ответ: %s", process(elTemp));
                System.out.println();
                token = true;
                elTemp = scanner.nextLine();
            }
        }
        scanner.close();
    }
}

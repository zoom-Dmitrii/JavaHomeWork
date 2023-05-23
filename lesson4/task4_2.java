
/*
Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя.
 */
import java.util.LinkedList;
import java.util.Scanner;

public class task4_2 {

    private static LinkedList<String> inLine = new LinkedList<>();

    private static void enqueue(String el) {
        inLine.add(el);
    }

    public static String dequeue() {
        String el = null;
        el = inLine.get(0);
        inLine.remove(0);
        return el;
    }

    public static String first() {
        return inLine.get(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Для добавления вводите элементы через Enter. Для окончания введите: st ");
        String elTemp = null;
        elTemp = scanner.nextLine();
        while (!elTemp.equals("st")) {
            enqueue(elTemp);
            System.out.println(inLine.toString());
            elTemp = scanner.nextLine();
        }
        System.out.println("Работа со списком. first() - возвращает первый элемент из очереди, не удаляя");
        System.out.println(first());
        System.out.println(inLine.toString());
        System.out.println("Работа со списком. dequeue() - возвращает первый элемент из очереди и удаляет его");
        System.out.println(dequeue());
        System.out.println(inLine.toString());
        scanner.close();
    }
}

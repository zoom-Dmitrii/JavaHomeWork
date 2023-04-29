
// Пусть дан LinkedList с несколькими элементами.
// Реализуйте метод(не void), который вернет “перевернутый” список.
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class task4_1 {

    public static LinkedList<String> reversList(LinkedList<String> el) {
        Collections.reverse(el);
        return el;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> inLine = new LinkedList<>();
        System.out.println("Вводите элементы через Enter. Для окончания введите: rev ");
        String elTemp = null;
        elTemp = scanner.nextLine();
        while (!elTemp.equals("rev")) {
            inLine.add(elTemp);
            System.out.println(inLine.toString());
            elTemp = scanner.nextLine();
        }
        System.out.println(reversList(inLine).toString());
        scanner.close();
    }
}

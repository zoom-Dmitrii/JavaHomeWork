/*
Задано уравнение вида q + w = e, q, w, e >= 0
например, 2? + ?5 = 69. Требуется восстановить выражение до верного равенства
Предложить хотя бы одно решение или сообщить, что его нет. Под знаками вопросов - одна и та же цифра
*/
import java.util.Scanner;

public class task4 {

    public static String calculat(String txtIn) {
        int res = 0;
        String txtWork = null;
        for (int i = 0; i <= 9; i++) {
            txtWork = txtIn.replace("?", Integer.toString(i));  
            String[] splitLine = txtWork.split(" ");
            res = Integer.parseInt(task3.calculation(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[2]), splitLine[1]));
            if (res == Integer.parseInt(splitLine[4])) {
                return "Есть решение: " + txtWork;
            }
        }
        return "Решения нет";
    }

    public static void main(String[] args) {
        String lineIn = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Задайте уравнение вида q + w = e, q, w, e >= 0 например, 2? + ?5 = 69");
        System.out.println("Под знаками вопросов - одна и та же цифра");
        System.out.println();
        System.out.println("Для примера уравнение: 6? + 3? = 100");
        lineIn = "6? + 3? = 100";
        System.out.println();
        System.out.println(calculat(lineIn));
        System.out.println();
        System.out.print("Введите Ваше уравнение, цифры и операторы через пробел: ");
        lineIn = scanner.nextLine();
        System.out.println();
        System.out.println(calculat(lineIn));
        scanner.close();
    }
    
}

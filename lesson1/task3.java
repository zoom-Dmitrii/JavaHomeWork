//Реализовать простой калькулятор
import java.util.Scanner;

public class task3 {

    public static String calculation(int num1, int num2, String operator) {

        switch (operator) {
            case "*":
                return Integer.toString(num1 * num2);
            case "/": {
                if (num2 == 0)
                    return "Делить на 0 нельзя";
                else{
                    int tmp = num1 / num2;
                    return Integer.toString(tmp);
                }
            }
            case "+":
                return Integer.toString(num1 + num2);
            case "-":
                return Integer.toString(num1 - num2);
        }
        return "Что-то пошло не так";

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Калькулятор. Введите последовательно: первое число -> оператор -> второе число");
        System.out.print("Введите первое число: ");
        int num1 = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите оператор: ");
        String operator = scanner.nextLine();
        System.out.print("Введите второе число: ");
        int num2 = Integer.parseInt(scanner.nextLine());
        System.out.println();
        System.out.println(calculation(num1, num2, operator));
        scanner.close();
    }
}

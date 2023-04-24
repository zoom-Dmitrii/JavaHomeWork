// Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

import java.util.Scanner;

public class task1{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n;
        System.out.print("Введите значение n: ");
        n = scanner.nextInt();
        System.out.printf("Сумма чисел от 1 до %d: %d", n, tringlSum(n));
        System.out.println("");
        System.out.printf("Факториал %d!: %d", n, factorial(n));
        scanner.close();
    }

    public static Integer tringlSum(int n) {
        if (n == 1) 
            return n;
        return n + tringlSum(n-1); 
    }

    public static Integer factorial(int n) {
        if (n == 1) 
            return n;
        return n * factorial(n-1); 
    }
}
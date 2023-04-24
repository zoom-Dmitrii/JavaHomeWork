// Вывести все простые числа от 1 до 1000

public class task2 {

    public static boolean checkNum(int num) {
        int temp = 0;
        for (int i = 2; i <= num / 2; i++) {
            temp = num % i;
            if (temp == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 1;
        while (n <= 1000) {
            if (checkNum(n)) {
                System.out.printf(" %d,", n);
            }
            n++;
        }
    }
}

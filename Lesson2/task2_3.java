
/*
 К калькулятору из предыдущего дз добавить логирование.
 1 + 3 = 4
 4 + 3 = 7
 */
import java.util.Scanner;

public class task2_3 {

    public static String calculat(String txtIn) {
        String res = "";
        String[] splitLine = txtIn.split(" ");
        res = 
                task3.calculation(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[2]), splitLine[1]);
        if (res.equals(splitLine[4])) {
            return String.format("Проверено:  %s %s %s = %s", splitLine[0], splitLine[1], splitLine[2], splitLine[4]);
        } else {
            res = task3.calculation(Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[0]), splitLine[1]);
            if (res.equals(splitLine[4])) {
                return String.format("Проверено:  %s %s %s = %s", splitLine[2], splitLine[1], splitLine[0], splitLine[4]);
            } else {
                res = task3.calculation(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[4]),splitLine[1]);
                if (res.equals(splitLine[2])) {
                    return String.format("Проверено:  %s %s %s = %s", splitLine[0], splitLine[1], splitLine[4], splitLine[2]);
                } else {
                    res = task3.calculation(Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[0]), splitLine[1]);
                    if (res.equals(splitLine[2])) {
                        return String.format("Проверено:  %s %s %s = %s", splitLine[4], splitLine[1], splitLine[0], splitLine[2]);
                    } else {
                        res = task3.calculation(Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[4]), splitLine[1]);
                        if (res.equals(splitLine[2])) {
                            return String.format("Проверено:  %s %s %s = %s", splitLine[2], splitLine[1], splitLine[4], splitLine[0]);
                        } else {
                            res = (task3.calculation(Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[2]), splitLine[1]));
                            if (res.equals(splitLine[2])) {
                                return String.format("Проверено:  %s %s %s = %s", splitLine[4], splitLine[1], splitLine[2], splitLine[0]);
                            }
                        }
                    }
                }
            }
        }
        return "Решения нет";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // task3.main(args);
        System.out.print("Введите Ваше уравнение, цифры и операторы через пробел: ");
        System.out.println(calculat(scanner.nextLine()));
        scanner.close();
    }

}

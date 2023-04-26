
/*
Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
результат после каждой итерации запишите в лог-файл.
*/
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class task2_1 {
    private static String filePatch = "test.txt"; // путь к файлу
    static private BufferedWriter bufferedWriter;
    static private boolean newfile = false;

    public static void sortMassiv(int[] mas) {
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] > mas[i + 1]) {
                    isSorted = false;
                    buf = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = buf;
                    saveTaskFile(Arrays.toString(mas));
                }
            }
        }
    }

    public static void saveTaskFile(String mas) {
        if (!newfile) {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(filePatch, StandardCharsets.UTF_8));
                newfile = true;
                bufferedWriter.append(mas);
                bufferedWriter.append('\n');
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                bufferedWriter.write(mas);
                bufferedWriter.append('\n');
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа через пробел");
        String[] textin = scanner.nextLine().split(" ");
        int[] massiv = Arrays.stream(textin).mapToInt(Integer::parseInt).toArray();
        sortMassiv(massiv);
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}

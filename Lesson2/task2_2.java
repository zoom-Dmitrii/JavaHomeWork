/*
Дана строка (получение через обычный текстовый файл!!!)

"фамилия":"Иванов","оценка":"5","предмет":"Математика"
"фамилия":"Петрова","оценка":"4","предмет":"Информатика"

Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
Студент [фамилия] получил [оценка] по предмету [предмет].
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class task2_2 {
    private static String filePatch = "data.txt"; // путь к файлу

    public static String loadDataFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePatch, StandardCharsets.UTF_8))) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static StringBuilder txtParse(String inTxt) {
        StringBuilder result = new StringBuilder();
        String[] parsLine = inTxt.split(",");
        for (String elString : parsLine) {
            String[] kv = elString.split(":");
            if (kv[0].contains("фамилия")) {
                result.append("Студент ")
                        .append(kv[1].replaceAll("\"", "")).append(" ");
            } else if (kv[0].contains("оценка")) {
                result.append("получил(а) ")
                        .append(kv[1].replaceAll("\"", "")).append(" ");
            } else if (kv[0].contains("предмет")) {
                result.append("по предмету ")
                        .append(kv[1].replaceAll("\"", "")).append(".");
            }

        }
        return result;
    }

    public static void main(String[] args) {
        String[] dataIn = loadDataFile().split("\r\n");
        for (String tmpLine : dataIn) {
            System.out.println(txtParse(tmpLine).toString());
        }
    }
}
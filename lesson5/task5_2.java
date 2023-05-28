package lesson5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class task5_2 {

    private static String filePatch = "lesson5/username.txt"; // путь к файлу

    public static String loadDataFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePatch, StandardCharsets.UTF_8))) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void txtParse(HashMap userList, String inTxt) {
        Integer number = null;
        String[] parsLine = inTxt.split(" ");
        if (userList.containsKey(parsLine[0])) { // если в HashMap есть имя, то инкремент индекса и запись
            number = (Integer) userList.get(parsLine[0]) + 1;
            userList.put(parsLine[0], number);
        } else {
            userList.put(parsLine[0], 1); // если в HashMap нет имени, добавляем имя и индекс 1
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> userList = new HashMap<>();
        String[] dataIn = loadDataFile().split("\r\n"); // Чтение файла с данными
        for (String tmpLine : dataIn) { // построчно отправляем значения на парсинг
            txtParse(userList, tmpLine);
        }
        for (String user : userList.keySet()) { // Вывод списка HashMap
            String key = user;
            String value = userList.get(user).toString();
            System.out.println(key + " " + value);
        }
        System.out.println("Соритрованный список");
        System.out.println("");
        Map<String, Integer> sortedMap = userList.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new));
        sortedMap.entrySet().forEach(System.out::println);
    }
}

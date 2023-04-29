// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class task3_3 {

    private static List<String> correctList(List<Integer> intList) {
        List<String> result = new ArrayList<>();
        result.add(String.format("Min:  %s", Collections.min(intList).toString()));
        result.add(String.format("Max:  %s", Collections.max(intList).toString()));
        result.add(String.format("Среднее:  %s", intList.stream()
                .mapToDouble(i -> i)
                .average().getAsDouble()));
        return result;
    }

    public static void main(String[] args) {
        List<Integer> intList = new Random().ints(20, 1, 101)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(intList);
        for (String el : correctList(intList)) {
            System.out.println(el);
        }
    }

}

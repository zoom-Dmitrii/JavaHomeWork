
// Пусть дан произвольный список целых чисел, удалить из него чётные числа
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class task3_2 {

    public static List<Integer> correctList(List<Integer> intList) {
        for (int el = intList.size() - 1; el >= 0; el--) {
            if (intList.get(el) % 2 == 0) {
                intList.remove(el);
            }
        }
        return intList;
    }

    public static void main(String[] args) {
        List<Integer> intList = new Random().ints(20, 1, 101)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(intList);
        System.out.println(correctList(intList));
    }
}

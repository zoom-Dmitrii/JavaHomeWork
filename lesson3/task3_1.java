// Реализовать алгоритм сортировки слиянием

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class task3_1 {
    
    // mergeSort разбивает коллекцию и рекурсивно вызывает себя
    public static void mergeSort(int[] array, int low, int high) { 
        if (high <= low) return; 
        int mid = (low+high)/2; 
        mergeSort(array, low, mid); 
        mergeSort(array, mid+1, high); 
        merge(array, low, mid, high); 
        } 

        // merge объединяет результаты в правильном порядке
        public static void merge(int[] array, int low, int mid, int high) { 
            // Создаем два промежуточных массива, левая и правая часть основного массива 
            int leftArray[] = new int[mid - low + 1]; 
            int rightArray[] = new int[high - mid]; 
            
            // Заполняем половинки значениями из основного 
            for (int i = 0; i < leftArray.length; i++) 
            leftArray[i] = array[low + i]; 
            for (int i = 0; i < rightArray.length; i++) 
            rightArray[i] = array[mid + i + 1]; 
            
            // Итераторы для промежуточных массивов 
            int leftIndex = 0; 
            int rightIndex = 0; 
            
            // Копируем подмассивы обратно в массив 
            for (int i = low; i < high + 1; i++) { 
            // Если в подмассивах все еще есть не элементы, вставим в основной массив минимальный из подмассивов 
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) { 
            if (leftArray[leftIndex] < rightArray[rightIndex]) { 
            array[i] = leftArray[leftIndex]; 
            leftIndex++; 
            } else { 
            array[i] = rightArray[rightIndex]; 
            rightIndex++; 
            } 
            } else if (leftIndex < leftArray.length) { 
            // Если все элементы из правого массива скопированы, скопируем оставшуюся часть leftArray 
            array[i] = leftArray[leftIndex]; 
            leftIndex++; 
            } else if (rightIndex < rightArray.length) { 
            // Если все элементы из левого массива скопированы, скопируем оставшуюся часть rightArray 
            array[i] = rightArray[rightIndex]; 
            rightIndex++; 
            } 
            } 
            } 

    public static void main(String[] args) {
        List<Integer> intList = new Random().ints(20, 1, 101)
                .boxed()
                .collect(Collectors.toList());
        int[] array = new int[intList.size()];
        for (int i = 0; i < intList.size(); i++) {
            array[i] = intList.get(i);
        }
        System.out.println(Arrays.toString(array)); 
        mergeSort(array, 0, array.length-1); 
        System.out.println(Arrays.toString(array)); 
    }
}

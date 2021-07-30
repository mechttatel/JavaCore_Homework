package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise8 extends Exercise {

    /*
         Алгоритм из merge sort, сначала с помощью метода getArray() пользователь
         вводит два массива, после чего в цикле последовательно сравнивается каждое значение
         двух массивов. Если значение из одного массива больше, оно заносится в массив результата
         и счетчик этого массива и результирующего сдвигаются влево (++)
         В массиве с меньшим значением счетчик не изменяется.
    */

    @Override
    public void run() {
        System.out.println("Числа в массив водятся построчно, для завершения ввода введите любой символ, кроме чисел");

        System.out.println("Вводите числа для первого массива:");
        int[] firstArray = getArray();

        System.out.println("Вводите числа для второго массива:");
        int[] secondArray = getArray();

        int[] result = new int[firstArray.length + secondArray.length];

        int i = 0, j = 0, k = 0;
        while (i < firstArray.length && j < secondArray.length) {
            if (firstArray[i] < secondArray[j]) {
                result[k] = firstArray[i];
                i++;
            } else {
                result[k] = secondArray[j];
                j++;
            }

            k++;
        }

        while (i < firstArray.length) {
            result[k] = firstArray[i];
            i++;
            k++;
        }

        while (j < secondArray.length) {
            result[k] = secondArray[j];
            j++;
            k++;
        }

        System.out.println("Результат:");
        System.out.println(Arrays.toString(result));
    }

    private int[] getArray() {
        List<Integer> list = new ArrayList<>();
        while (true) {
            try {
                int digit = Integer.parseInt(scanner.next());
                list.add(digit);
            }
            catch (Exception e) {
                System.out.println("Ввод завершен");
                return list.stream().mapToInt(i->i).toArray();
            }
        }
    }
}

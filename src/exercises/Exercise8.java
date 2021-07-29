package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise8 extends Exercise {

    @Override
    public void run() {
        int[] firstArray = getArray();
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
                return list.stream().mapToInt(i->i).toArray();
            }
        }
    }

}

import java.io.*;
import java.time.temporal.Temporal;
import java.util.*;

import static java.util.stream.Collectors.joining;

class MissingNumbersHackerrank {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static int[] missingNumbers(int[] arr, int[] brr) {

        TreeMap<Integer, Integer> integerTreeMap = new TreeMap<>();

        for (int i : brr) {
            int freq = integerTreeMap.getOrDefault(i, 0);
            freq++;
            integerTreeMap.put(i, freq);
        }
        for (int i : arr) {
            int freq = integerTreeMap.get(i);
            freq--;
            if (freq == 0) {
                integerTreeMap.remove(i);
            } else
                integerTreeMap.put(i, freq);

        }

        int[] result = new int[integerTreeMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> treeMap : integerTreeMap.entrySet()) {
            result[i++] = treeMap.getKey();
        }
        return result;
    }



    public static void main(String[] args) throws IOException {
        int[] brr = {7, 6, 5, 4, 3, 2, 8, 7};
        int[] arr = {7, 6, 5, 4, 3, 2};


        int[] result = missingNumbers(arr, brr);
        System.out.println("result   " + Arrays.toString(result));
    }
}

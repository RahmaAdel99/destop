import java.util.HashSet;

public class DuplicateElement {

        public static void main(String[] args) {
            int[] array = {5, 17, 5, 7, 4, -1};
            int duplicateIndex = findFirstDuplicate(array);

            System.out.println(duplicateIndex);  // Output: 3
        }

        public static int findFirstDuplicate(int[] array) {
            HashSet<Integer> set = new HashSet<>();

            for (int i = 0; i < array.length; i++) {
                if (set.contains(array[i])) {
                    return i;
                }
                set.add(array[i]);
            }

            return -1; // No duplicates found
        }
    }


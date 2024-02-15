import java.util.*;

public class UniqueData {


    public static void main(String[] args) {
        String[] input = {"apples", "oranges", "flowers", "apples"};
        String[] uniqueEntries = unique(input);

        System.out.println(Arrays.toString(uniqueEntries));
    }

    public static String[] unique(String[] input) {

        Set<String> uniqueSet = new HashSet<>(Arrays.asList(input));

        return uniqueSet.toArray(new String[0]);
    }
}


// Java program to find missing Number

import java.util.*;
import java.util.Arrays;

class missedNumber {

    // Function to find the missing number
    public static int getMissingNo(int[] nums, int n)
    {
        int sum = ((n + 1) * (n + 2)) / 2;
        for (int i = 0; i < n; i++)
            sum -= nums[i]; // sum = sum + i // sum = sum - num[i]
        return sum;
    }

    // Driver code
    public static void main(String[] args)
    {
        int[] arr = { 4,3,2,6};
        int N = arr.length;
        System.out.println(getMissingNo(arr, N));
    }
}
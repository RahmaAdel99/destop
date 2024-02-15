import java.util.Scanner;

public class Longestdistance {

    public static void main(String []args){
        LongestDistance();
    }

    static void LongestDistance(){
        int [] arr = new int[]{7, 0, 0, 0, 5, 6, 7, 5, 0, 7, 7, 7};
        int minIndex = 0;
        int MaxIndex = 0;
        int Maxvalue = 0;
        for (int i = 0; i<arr.length ; i++) {
            for (int j =i+1 ; j < arr.length;j++){
                if (arr[i] == arr[j]) {
                    if (j-i > Maxvalue) {
                        Maxvalue = j-i-1;
                        minIndex = i;
                        MaxIndex = j;
                    }
                }
            }
        }
        System.out.println(Maxvalue);
    }
}


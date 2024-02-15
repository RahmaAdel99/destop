package AmazonProblems;

public class reverseInteger {

    public static void reverse(int i){
        long result = 0;
        while (i != 0){
          int remainder = i % 10;
          result = result * 10 + remainder;
           i /= 10 ;
        }
        System.out.println(result);
    }
    public static void main(String []args){
        int x = -1234;
        reverse(x);
    }
}

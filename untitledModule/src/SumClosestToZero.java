import java.util.Arrays;

public class SumClosestToZero {


    public static void closestSum(int[] arr){
        int r = 0 , l =1 ;  int zerosum , sum ;

        if(arr.length-1 <2 ){
            System.out.println("Invalid Input");
        }
        zerosum = arr[0] + arr[1];

        for (int i = 0 ;i< arr.length-1 ; i++){
            for (int j =1 ; j< arr.length;j++){
                sum = arr[i] + arr[j];
                if (Math.abs(zerosum)>Math.abs(sum)){
                    zerosum = sum;
                    l = i ;
                    r = j ;
                }
            }
        }
        System.out.println("the two numbers whose cloest to zero  = " + arr[l] + " & " +arr[r] + "  =  0 ");
    }

//    public static void main(String []args){
//
//   int[] arr = {1, 60, -10, 70, -80, 80};
//        closestSum(arr);
//
//    }

/*    String str = "rahma adel";
    StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.reverse();
        System.out.println(stringBuilder);*/


    public static void main(String []args){
        String str = "rahma adel";

        char[] ch = str.toCharArray();
        for (int i= ch.length - 1 ; i >=0 ; i--){
            System.out.print(ch[i]);
        }
    }

}

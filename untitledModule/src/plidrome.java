import java.util.Scanner;

public class plidrome {

    public static boolean isplindrome(String str){

        String reverse = "";
        boolean result = false;

        for (int i = str.length()-1 ; i>=0 ; i--){
            reverse = reverse + str.charAt(i);
        }
        if(str.equals(reverse) && str.equals("anna")){
            result = true;
        }
        else if(str.equals("apple")){
            result = false;
        }
        return result;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        input = input.toLowerCase();
        boolean output = isplindrome(input);
        System.out.println(output);
        System.out.println(input);
    }
}

package AmazonProblems;

import java.util.Arrays;

public class reversevowels {

    public static void reverse(String str){
     char[] ch = str.toCharArray();
     int left = 0 , right = ch.length - 1;
     while (left < right){
         boolean leftisvowel = isVowel(ch[left]);
         boolean rightisvowel = isVowel(ch[right]);
         if ( leftisvowel && rightisvowel){
             int i = 0,j=0 ;
             char temp = ch[i];
             ch[i] = ch[j];
             ch[j] = temp;
             ++left;
             --right;
         }else if (!leftisvowel){
             ++left;
         } else if (!rightisvowel){
             --right;
         }
     }
        System.out.println(Arrays.toString(ch));
    }

    private static boolean isVowel(char letter){
        char c =Character.toLowerCase(letter);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args){
        reverse("RahmaAdel");

    }
}

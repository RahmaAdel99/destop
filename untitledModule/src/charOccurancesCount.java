import java.util.HashMap;

public class charOccurancesCount {

    static void charCount(String str){

        HashMap<Character,Integer> occurances = new HashMap<>();
        for (int i = 0;i<str.length();i++){
            if(occurances.containsKey(str.charAt(i))){

                int count = occurances.get(str.charAt(i));
                occurances.put(str.charAt(i),++count);
            }
            else
                occurances.put(str.charAt(i),1);
        }
        System.out.println(occurances);
    }

    public static void main(String []args){
        charCount("rahmaahmed");
    }
}

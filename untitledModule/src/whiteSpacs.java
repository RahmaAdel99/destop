public class whiteSpacs {

    public static void main(String[] args) {
        System.out.println(noOfwhitespaces("rahma adel  fax"));
    }

    private static int noOfwhitespaces(String fullName) {
        int count = 0;
        for (char st : fullName.toString().toCharArray()) {
            if (st == ' ') {
                count++;
            }
        }
        return count;
    }
}

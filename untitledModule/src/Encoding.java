public class Encoding {
    public static String Encode(String input) {
        StringBuilder encodedString = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= input.length(); i++) {
            if (i == input.length() || input.charAt(i) != input.charAt(i - 1)) {
                encodedString.append(count);
                encodedString.append(input.charAt(i - 1));
                count = 1;
            } else {
                count++;
            }
        }

        return encodedString.toString();
    }

    public static String Decode(String input) {
        StringBuilder decodedString = new StringBuilder();
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (Character.isDigit(currentChar)) {
                count = count * 10 + (currentChar - '0');
            } else {
                for (int j = 0; j < count; j++) {
                    decodedString.append(currentChar);
                }

                count = 0;
            }
        }

        return decodedString.toString();
    }

    public static void main(String[] args) {
        String input = "aaaaaaaaaabbbaxxxxyyyzyx";
        String encoded = Encode(input);
        String decoded = Decode(encoded);

        System.out.println("Original String: " + input);
        System.out.println("Encoded String: " + encoded);
        System.out.println("Decoded String: " + decoded);
    }
}
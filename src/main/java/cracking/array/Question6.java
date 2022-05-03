package cracking.array;

public class Question6 {
    public static String compress(String msg) {
        StringBuilder builder = new StringBuilder();

        int start = 0;
        while (start < msg.length()) {
            char currentChar = msg.charAt(start);
            int numChar =0;
            while (start <msg.length() && msg.charAt(start) == currentChar){
                numChar++;
                start++;
            }
            builder.append(currentChar).append(numChar);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
    }
}

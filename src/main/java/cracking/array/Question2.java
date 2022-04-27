package cracking.array;

public class Question2 {

    private static boolean isPermutation1(String st1, String st2) {
        if (st1.length() != st2.length()) return false;

        int[] countLetter1 = new int[128];
        int[] countLetter2 = new int[128];

        for (int i = 0; i < st1.length(); i++) {
            int index = st1.charAt(i);
            countLetter1[index]++;
        }

        for (int i = 0; i < st2.length(); i++) {
            int index = st2.charAt(i);
            countLetter2[index]++;
        }

        for (int i =0 ; i< countLetter1.length; i++){
            if (countLetter1[i] != countLetter2[i]){
                return false;
            }
        }

        return true;
    }

    private static boolean isPermutation2(String st1, String st2) {
        if (st1.length() != st2.length()) return false;

        int[] countLetter1 = new int[128];

        for (int i = 0; i < st1.length(); i++) {
            int index = st1.charAt(i);
            countLetter1[index]++;
        }

        for (int i = 0; i < st2.length(); i++) {
            int index = st2.charAt(i);
            countLetter1[index]--;
            if (countLetter1[index] <0){
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isPermutation1(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }

        System.out.println("----------------------------");

        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isPermutation2(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }
}

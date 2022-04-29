package cracking.array;

import java.util.Locale;

public class Question4 {
    public static boolean checkPalindromePermutation(String check) {
        boolean[] table = new boolean['z' - 'a'];

        for (int i = 0; i < check.length(); i++) {
            int index = check.charAt(i) - 'a';
            if (index <0) continue;

            table[index] = !table[index];
        }

        int numberOfTrue = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i]) {
                numberOfTrue++;
            }
        }

        return numberOfTrue <= 1;
    }

    public static void main(String[] args) {
        String pali = "Tact Coa".toLowerCase();
        System.out.println(checkPalindromePermutation(pali));
    }
}

package cracking.array;

public class Question1 {

    public static boolean isUnique1(String checkString) {
        boolean[] checkPosition = new boolean[128];

        for (int i = 0; i < checkString.length(); i++) {
            int index = checkString.charAt(i);
            if (checkPosition[index]) {
                return false;
            }
            checkPosition[index] = true;
        }
        return true;
    }

    public static boolean isUnique2(String checkString) {
        int checkNum = 0;


        for (int i = 0; i < checkString.length(); i++) {
            int index = checkString.charAt(i) - 'a';
            if ((checkNum & (1<<index))  > 0){
                return false;
            }
            checkNum |= (1 <<index);
        }


        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUnique2(word));
        }
    }
}

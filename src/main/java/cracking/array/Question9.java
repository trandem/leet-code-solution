package cracking.array;

public class Question9 {

    public static boolean stringRotation(String s1,String s2){
        if (s1.length() != s2.length()) return false;

        String s1s1 = s1+s1;

        return s1s1.contains(s2);

    }

    public static void main(String[] args) {

    }
}

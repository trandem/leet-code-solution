package cracking.array;

public class Question5 {
    public static boolean oneway(String st1, String st2) {
        int length1 = st1.length();
        int length2 = st2.length();

        int sub = Math.abs(length1 - length2);

        if (sub > 1) return false;

        if (length1> length2){
            foundDiff(st2,st1);
        }

        return foundDiff(st1, st2);
    }

    public static boolean foundDiff(String st1, String st2) {

        int start = 0;
        boolean foundDiff = false;
        while (start < st1.length()) {
            if (st1.charAt(start) != st2.charAt(start)) {
                if (!foundDiff) {
                    foundDiff = true;
                } else {
                    return false;
                }
            }
            start++;
        }
        if (st1.length() < st2.length() && foundDiff) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(oneway("pale","ple"));
        System.out.println(oneway("pales","pale"));
        System.out.println(oneway("pale","bale"));
        System.out.println(oneway("pale","bake"));
    }


}

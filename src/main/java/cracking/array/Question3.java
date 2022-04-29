package cracking.array;

public class Question3 {

    public static void urlVerify(char[] origin, int length) {
        int numberOfSpace = 0;

        for (int i = length-1; i >= 0; i--) {
            if (origin[i] == ' ') {
                numberOfSpace++;
            }
        }

        int newIndex = length + numberOfSpace * 2;

        for (int i = length - 1; i >= 0; i--) {
            if (origin[i] == ' ') {
                origin[newIndex - 1] = '0';
                origin[newIndex - 2] = '2';
                origin[newIndex - 3] = '%';
                newIndex = newIndex - 3;
            } else {
                origin[newIndex -1 ] = origin[i];
                newIndex--;
            }
        }

    }

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        int trueLength = 13;
        urlVerify(arr, trueLength);
        System.out.println(new String(arr));
    }
}

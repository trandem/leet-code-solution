package problems;

import java.util.*;

/**
 * 38. Count and Say
 * Medium
 * <p>
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 * To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.
 * <p>
 * For example, the saying and conversion for digit string "3322251":
 * <p>
 * <p>
 * Given a positive integer n, return the nth term of the count-and-say sequence.
 */
public class CountAndSay {
    public static String countAndSay(int n) {

        String currentSay = "1";
        for (int i =2 ; i<=n ; i++){
            currentSay = countAndSay(currentSay);
        }
        return currentSay;
    }

    public static String countAndSay(String number) {
        StringBuilder builder = new StringBuilder("");
        int start = 0;
        while (start < number.length()) {
            int count =0;
            char currentChar = number.charAt(start);
            while (start < number.length() && currentChar == number.charAt(start)){
                count++;
                start++;
            }
            builder.append(count).append(currentChar);
        }

        return builder.toString();
    }

    public static class ReveredOrderInteger implements Comparable<ReveredOrderInteger>{
        int data;

        public ReveredOrderInteger(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        @Override
        public int compareTo(ReveredOrderInteger other) {
            return Integer.compare(other.data, this.data);
        }

        @Override
        public String toString() {
            return "ReveredOrderInteger{" +
                    "data=" + data +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<ReveredOrderInteger> x = new ArrayList<>();
        x.add(new ReveredOrderInteger(13));
        x.add(new ReveredOrderInteger(15));
        x.add(new ReveredOrderInteger(1));
        x.add(new ReveredOrderInteger(20));
        x.add(new ReveredOrderInteger(4));

        PriorityQueue<ReveredOrderInteger> maxHeap = new PriorityQueue<>(x);

        while (!maxHeap.isEmpty()){
            System.out.println(maxHeap.poll());
        }
    }
}

package stackdfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Daily Temperatures
 * <p>
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 * <p>
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 * <p>
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 */
public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> indexStack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while (!indexStack.isEmpty() && temp > temperatures[indexStack.peek()]) {
                temperatures[indexStack.peek()] = i - indexStack.pop();
            }
            indexStack.push(i);
        }
        for (int index : indexStack) {
            temperatures[index] = 0;
        }

        return temperatures;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        dailyTemperatures(temperatures);
        for (int a : temperatures) {
            System.out.printf(a + " ");
        }
    }
}

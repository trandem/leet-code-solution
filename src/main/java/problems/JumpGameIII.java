package problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1306. Jump Game III
 * Medium
 * <p>
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
 * <p>
 * Notice that you can not jump outside of the array at any time.
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [4,2,3,0,3,1,2], start = 5
 * Output: true
 * Explanation:
 * All possible ways to reach at index 3 with value 0 are:
 * index 5 -> index 4 -> index 1 -> index 3
 * index 5 -> index 6 -> index 4 -> index 1 -> index 3
 * Example 2:
 * <p>
 * Input: arr = [4,2,3,0,3,1,2], start = 0
 * Output: true
 * Explanation:
 * One possible way to reach at index 3 with value 0 is:
 * index 0 -> index 4 -> index 1 -> index 3
 * Example 3:
 * <p>
 * Input: arr = [3,0,2,1,2], start = 2
 * Output: false
 * Explanation: There is no way to reach at index 1 with value 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 5 * 104
 * 0 <= arr[i] < arr.length
 * 0 <= start < arr.length
 */
public class JumpGameIII {
    public static boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int index = queue.poll();
            visited[index] = true;

            if (arr[index] ==0) return true;

            int next1 = index + arr[index];
            int next2 = index - arr[index];

            if (next1< arr.length && !visited[next1]){
                queue.offer(next1);
            }

            if (next2>= 0 && !visited[next2]){
                queue.offer(next2);
            }

        }

        return false;
    }

    public static boolean canReach1(int[] arr, int start) {
        if(start<0 || start>=arr.length || arr[start]<0) return false;
        if(arr[start] == 0) return true;

        arr[start] = -arr[start];
        return canReach1(arr, start + arr[start]) || canReach1(arr, start - arr[start]);
    }

    public static void main(String[] args) {
        System.out.println(canReach(new int[]{58,48,64,36,19,19,67,13,32,2,59,50,29,68,50,0,69,31,54,20,22,43,30,9,
                                             68,71,20,22,48,74,2, 65,27,54,30,5,66,24,64,68,9,31,50,59,15,72,6,49,11,71,12,61,5,66,30,1,2,39,59,
                35,53,21,76,17,71,40,68,57,64,53,70,21,50,49,25,63,35},46));
    }
}

package problems;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 1856. Maximum Subarray Min-Product
 * Medium
 * <p>
 * The min-product of an array is equal to the minimum value in the array multiplied by the array's sum.
 * <p>
 * For example, the array [3,2,5] (minimum value is 2) has a min-product of 2 * (3+2+5) = 2 * 10 = 20.
 * Given an array of integers nums, return the maximum min-product of any non-empty subarray of nums. Since the answer may be large, return it modulo 109 + 7.
 * <p>
 * Note that the min-product should be maximized before performing the modulo operation. Testcases are generated such that the maximum min-product without modulo will fit in a 64-bit signed integer.
 * <p>
 * A subarray is a contiguous part of an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,2]
 * Output: 14
 * Explanation: The maximum min-product is achieved with the subarray [2,3,2] (minimum value is 2).
 * 2 * (2+3+2) = 2 * 7 = 14.
 * Example 2:
 * <p>
 * Input: nums = [2,3,3,1,2]
 * Output: 18
 * Explanation: The maximum min-product is achieved with the subarray [3,3] (minimum value is 3).
 * 3 * (3+3) = 3 * 6 = 18.
 * Example 3:
 * <p>
 * Input: nums = [3,1,5,6,4,2]
 * Output: 60
 * Explanation: The maximum min-product is achieved with the subarray [5,6,4] (minimum value is 4).
 * 4 * (5+6+4) = 4 * 15 = 60.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 107
 */
public class MaximumSubarrayMinProduct {
    public static int maxSumMinProduct(int[] nums) {

        Stack<Integer> st = new Stack<>();
        long[] dp = new long[nums.length + 1];

        for (int i = 0; i< nums.length; i++){
            dp[i+1] = dp[i] + nums[i];
        }
        long max = Long.MIN_VALUE;
        for (int i = 0; i <= nums.length; i++) {
            while (!st.isEmpty() && (i == nums.length || nums[st.peek()] > nums[i])) {
                int index = st.pop();
                long sum =  dp[i] - dp[st.isEmpty() ? 0 : st.peek() + 1];
                long localMax = sum * nums[index];
                max = Math.max(max, localMax);
            }
            st.push(i);
        }

        return (int) (max % 1000000007);
    }

    public static int maxSumMinProduct1(int[] n) {
        Stack<Integer> st = new Stack<>();
        long[] dp = new long[n.length + 1];
        long res = 0;
        for (int i = 0; i < n.length; ++i)
            dp[i + 1] = dp[i] + n[i];
        for (int i = 0; i <= n.length; ++i) {
            while (!st.empty() && (i == n.length || n[st.peek()] > n[i])) {
                int j = st.pop();
                res = Math.max(res, (dp[i] - dp[st.empty() ? 0 : st.peek() + 1]) * n[j]);
            }
            st.push(i);
        }
        return (int) (res % 1000000007);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 1, 2};
        System.out.println(maxSumMinProduct(nums));
        System.out.println(maxSumMinProduct1(nums));
    }

}

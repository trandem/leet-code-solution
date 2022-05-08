package problems;


/**
 * 1004. Max Consecutive Ones III
 * Medium
 * <p>
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * Example 2:
 * <p>
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 * 0 <= k <= nums.length
 */
public class MaxConsecutiveOnesIII {
    public static int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        int start = 0;
        int end = 0;
        int countZero = 0;

        while (end < nums.length) {
            if (nums[end] == 0) countZero++;
            if (countZero > k) {
                while (nums[start++] != 0) {
                }
                countZero--;
            }
            int length = end - start +1;
            maxLength = Math.max(maxLength, length);
            end++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int []nums ={0,0,0,1};
        int k =4;
        System.out.println(longestOnes(nums,k));
    }

}

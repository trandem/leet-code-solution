package problems;

/**
 * Minimum Average Difference
 * Medium
 * <p>
 * Share
 * You are given a 0-indexed integer array nums of length n.
 * <p>
 * The average difference of the index i is the absolute difference between the average of the first i + 1 elements of nums and the average of the last n - i - 1 elements.
 * Both averages should be rounded down to the nearest integer.
 * <p>
 * Return the index with the minimum average difference. If there are multiple such indices, return the smallest one.
 * <p>
 * Note:
 * <p>
 * The absolute difference of two numbers is the absolute value of their difference.
 * The average of n elements is the sum of the n elements divided (integer division) by n.
 * The average of 0 elements is considered to be 0.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,3,9,5,3]
 * Output: 3
 * Explanation:
 * - The average difference of index 0 is: |2 / 1 - (5 + 3 + 9 + 5 + 3) / 5| = |2 / 1 - 25 / 5| = |2 - 5| = 3.
 * - The average difference of index 1 is: |(2 + 5) / 2 - (3 + 9 + 5 + 3) / 4| = |7 / 2 - 20 / 4| = |3 - 5| = 2.
 * - The average difference of index 2 is: |(2 + 5 + 3) / 3 - (9 + 5 + 3) / 3| = |10 / 3 - 17 / 3| = |3 - 5| = 2.
 * - The average difference of index 3 is: |(2 + 5 + 3 + 9) / 4 - (5 + 3) / 2| = |19 / 4 - 8 / 2| = |4 - 4| = 0.
 * - The average difference of index 4 is: |(2 + 5 + 3 + 9 + 5) / 5 - 3 / 1| = |24 / 5 - 3 / 1| = |4 - 3| = 1.
 * - The average difference of index 5 is: |(2 + 5 + 3 + 9 + 5 + 3) / 6 - 0| = |27 / 6 - 0| = |4 - 0| = 4.
 * The average difference of index 3 is the minimum average difference so return 3.
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: 0
 * Explanation:
 * The only index is 0 so return 0.
 * The average difference of index 0 is: |0 / 1 - 0| = |0 - 0| = 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 */
public class MinimumAverageDifference {
    public int minimumAverageDifference(int[] nums) {
        long minDiff = Integer.MAX_VALUE;
        long total = 0;
        for (int num : nums) {
            total += num;
        }

        long sumLeft = 0, sumRight = 0;

        int index =-1;
        for (int i = 0; i < nums.length; i++) {
            sumLeft += nums[i];
            long avgLeft = sumLeft / (i + 1);

            sumRight = total - sumLeft;

            long avgRight = nums.length - i == 1 ? 0 : sumRight / (nums.length - i - 1);

            long diff = Math.abs(avgLeft - avgRight);

            if (diff < minDiff){
                minDiff = diff;
                index = i;
            }

        }

        return index;
    }

    public int minimumAverageDifference1(int[] nums) {
        int len = nums.length, res = 0;
        long min = Integer.MAX_VALUE, sum = 0, leftSum = 0, rightSum = 0;
        for (int num : nums)
            sum += num;
        for (int i = 0; i < len; i++) {
            leftSum += nums[i];
            rightSum = sum - leftSum;
            long diff = Math.abs(leftSum / (i + 1) - (len - i == 1 ? 0 : rightSum / (len -i - 1)));
            if (diff < min) {
                min = diff;
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 5, 3, 9, 5, 3};
        //System.out.println(minimumAverageDifference(nums1));
//        int[] nums2 = {0};
//        System.out.println(minimumAverageDifference(nums2));
    }
}

package problems;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 1818. Minimum Absolute Sum Difference
 * Medium
 * <p>
 * Share
 * You are given two positive integer arrays nums1 and nums2, both of length n.
 * <p>
 * The absolute sum difference of arrays nums1 and nums2 is defined as the sum of |nums1[i] - nums2[i]| for each 0 <= i < n (0-indexed).
 * <p>
 * You can replace at most one element of nums1 with any other element in nums1 to minimize the absolute sum difference.
 * <p>
 * Return the minimum absolute sum difference after replacing at most one element in the array nums1. Since the answer may be large, return it modulo 109 + 7.
 * <p>
 * |x| is defined as:
 * <p>
 * x if x >= 0, or
 * -x if x < 0.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,7,5], nums2 = [2,3,5]
 * Output: 3
 * Explanation: There are two possible optimal solutions:
 * - Replace the second element with the first: [1,7,5] => [1,1,5], or
 * - Replace the second element with the third: [1,7,5] => [1,5,5].
 * Both will yield an absolute sum difference of |1-2| + (|1-3| or |5-3|) + |5-5| = 3.
 * Example 2:
 * <p>
 * Input: nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
 * Output: 0
 * Explanation: nums1 is equal to nums2 so no replacement is needed. This will result in an
 * absolute sum difference of 0.
 * Example 3:
 * <p>
 * Input: nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
 * Output: 20
 * Explanation: Replace the first element with the second: [1,10,4,4,2,7] => [10,10,4,4,2,7].
 * This yields an absolute sum difference of |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums1.length
 * n == nums2.length
 * 1 <= n <= 105
 * 1 <= nums1[i], nums2[i] <= 105
 */
public class MinimumAbsoluteSumDifference {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        long sum = 0;
        Arrays.binarySearch(nums1,2);

        long maxDecease = 0;
        TreeSet<Integer> sorted = new TreeSet<>();
        for (int num : nums1) {
            sorted.add(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            sum += Math.abs(nums1[i] - nums2[i]);

            Integer floor = sorted.floor(nums2[i]);
            Integer cell = sorted.ceiling(nums2[i]);

            int diff = Math.abs(nums1[i] - nums2[i]);
            int max = 0;
            if (floor != null) {
                max = Math.max(max, diff - Math.abs(floor - nums2[i]));
            }
            if (cell != null) {
                max = Math.max(max, diff - Math.abs(cell - nums2[i]));
            }
            maxDecease = Math.max(max, maxDecease);
        }


        return (int) ((sum - maxDecease) % (1e9 + 7));
    }

}

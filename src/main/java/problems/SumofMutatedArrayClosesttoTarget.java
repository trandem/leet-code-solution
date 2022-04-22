package problems;

/**
 * 1300. Sum of Mutated Array Closest to Target
 * Medium
 * <p>
 * Given an integer array arr and a target value target, return the integer value such that when we change all the integers larger than value in the given array to be equal to value, the sum of the array gets as close as possible (in absolute difference) to target.
 * <p>
 * In case of a tie, return the minimum such integer.
 * <p>
 * Notice that the answer is not neccesarilly a number from arr.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [4,9,3], target = 10
 * Output: 3
 * Explanation: When using 3 arr converts to [3, 3, 3] which sums 9 and that's the optimal answer.
 * Example 2:
 * <p>
 * Input: arr = [2,3,5], target = 10
 * Output: 5
 * Example 3:
 * <p>
 * Input: arr = [60864,25176,27249,21296,20204], target = 56803
 * Output: 11361
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 104
 * 1 <= arr[i], target <= 105
 */
public class SumofMutatedArrayClosesttoTarget {
    public static int findBestValue(int[] arr, int target) {
        int min = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int v = 1;
        int subMin = Integer.MAX_VALUE;
        for (int i = min; i <= max; i++) {
            int sum = sum(arr, i);

            if (Math.abs(sum - target) < subMin) {
                subMin = Math.abs(sum - target);
                v = i;
            }
        }
        System.out.println(subMin);
        return v;
    }

    public static int sum(int[] arr, int replaceData) {
        int sum = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            sum += Math.min(arr[i], replaceData);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {60864,25176,27249,21296,20204};
        System.out.println(findBestValue(arr,56803));

    }
}

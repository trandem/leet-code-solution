package stackdfs;

/**
 * Target Sum
 * <p>
 * You are given an integer array nums and an integer target.
 * <p>
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 * <p>
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * Example 2:
 * <p>
 * Input: nums = [1], target = 1
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 */
public class TargetSum {
    static int count = 0;
    public static int findTargetSumWays(int[] nums, int target) {
        calculate( 0, target, 0, nums);
        return count;
    }

    public static void calculate( int index, int target, int sum, int[] nums) {
        if (index == nums.length - 1) {
            int temp = sum + nums[index];
            if (temp == target) {
                count++;
            }
            temp =sum - nums[index];
            if (temp == target) {
                count++;
            }
        } else {
            calculate( index + 1, target, sum + nums[index], nums);
            calculate( index + 1, target, sum - nums[index], nums);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(findTargetSumWays(nums,3));
    }
}

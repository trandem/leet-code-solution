package problems;

/**
 * 1567. Maximum Length of Subarray With Positive Product
 * <p>
 * Share
 * Given an array of integers nums, find the maximum length of a subarray where the product of all its elements is positive.
 * <p>
 * A subarray of an array is a consecutive sequence of zero or more values taken out of that array.
 * <p>
 * Return the maximum length of a subarray with positive product.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,-2,-3,4]
 * Output: 4
 * Explanation: The array nums already has a positive product of 24.
 * Example 2:
 * <p>
 * Input: nums = [0,1,-2,-3,-4]
 * Output: 3
 * Explanation: The longest subarray with positive product is [1,-2,-3] which has a product of 6.
 * Notice that we cannot include 0 in the subarray since that'll make the product 0 which is not positive.
 * Example 3:
 * <p>
 * Input: nums = [-1,-2,-3,0,1]
 * Output: 2
 * Explanation: The longest subarray with positive product is [-1,-2] or [-2,-3].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class MaximumLengthOfSubarrayWithPositiveProduct {

    public static int getMaxLen(int[] nums) {
        int max = 0;
        int lastIndex = 0;
        int lastIndexNegative = -1;
        int numNegative = 0;


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                lastIndex = i + 1;
                lastIndexNegative = -1;
                numNegative = 0;
            }
            if (nums[i] > 0&& numNegative%2 ==1) {
                max = Math.max(i -lastIndexNegative,max);
            }
            if (nums[i] < 0) {
                if(lastIndexNegative==-1) lastIndexNegative=i;
                numNegative++;
            }

            if (numNegative % 2 == 0) {
                int localLength = i- lastIndex +1;
                max = Math.max(localLength,max);
            }
        }
        return max;
    }

    static int getMaxLenCopy(int[] nums) {
        int n=nums.length,mx=0, last_index=0,last_neg_index=-1,neg=0;
        for(int i=0;i<n;++i){
            if(nums[i]==0) {
                last_index = i + 1;
                last_neg_index = -1;
                neg = 0;
            }else if(nums[i]<0){
                if(last_neg_index==-1) last_neg_index=i;
                neg++;
            }
            else if(nums[i]>0 && neg%2 ==1) mx=Math.max(mx,i-last_neg_index);
            if(neg%2==0) mx=Math.max(mx,i-last_index+1);
        }
        return mx;
    }

    public static void main(String[] args) {
        int[] nums = {-1};
        System.out.println(getMaxLen(nums));
        System.out.println(getMaxLenCopy(nums));
    }
}

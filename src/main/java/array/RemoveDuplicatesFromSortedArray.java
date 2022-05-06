package array;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int count =1;
        int currentIndex = 0;
        for (int i =1; i< nums.length;i++){
            if (nums[i] > nums[currentIndex]){

                nums[count] = nums[i];
                count++;
                currentIndex = i;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int []x = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(x));
    }
}

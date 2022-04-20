package array;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Replace Elements with Greatest Element on Right Side
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
 * <p>
 * After doing so, return the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 * Explanation:
 * - index 0 --> the greatest element to the right of index 0 is index 1 (18).
 * - index 1 --> the greatest element to the right of index 1 is index 4 (6).
 * - index 2 --> the greatest element to the right of index 2 is index 4 (6).
 * - index 3 --> the greatest element to the right of index 3 is index 4 (6).
 * - index 4 --> the greatest element to the right of index 4 is index 5 (1).
 * - index 5 --> there are no elements to the right of index 5, so we put -1.
 * Example 2:
 * <p>
 * Input: arr = [400]
 * Output: [-1]
 * Explanation: There are no elements to the right of index 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 104
 * 1 <= arr[i] <= 105
 */
public class GreatestElementOnRightSide {


    //Big(O) = n^2, space O(1)
    public static int[] replaceElementsn2(int[] arr) {

        if (arr.length == 1) {
            arr[0] = -1;
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            int maxRight = Integer.MIN_VALUE;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > maxRight) {
                    maxRight = arr[j];
                }
                arr[i] = maxRight;
            }
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

    //Speed O(n^2), space O(1)
    public static int[] replaceElements(int[] arr) {
        int maximumRight = arr[arr.length-1];

        for (int i = arr.length - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = maximumRight;
            if (temp > maximumRight){
                maximumRight = temp;
            }
        }

        arr[arr.length - 1] = -1;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {17, 18, 5, 4, 6, 1};
        replaceElements(arr);
        for (int a : arr) {
            System.out.printf(a + " ");
        }
    }
}

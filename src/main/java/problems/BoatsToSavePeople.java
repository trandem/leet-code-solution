package problems;

import java.util.Arrays;

/**
 * 881. Boats to Save People
 * <p>
 * Share
 * You are given an array people where people[i] is the weight of the ith person,
 * and an infinite number of boats where each boat can carry a maximum weight of limit.
 * Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
 * <p>
 * Return the minimum number of boats to carry every given person.
 * <p>
 * Example 1:
 * <p>
 * Input: people = [1,2], limit = 3
 * Output: 1
 * Explanation: 1 boat (1, 2)
 * Example 2:
 * <p>
 * Input: people = [3,2,2,1], limit = 3
 * Output: 3
 * Explanation: 3 boats (1, 2), (2) and (3)
 * Example 3:
 * <p>
 * Input: people = [3,5,3,4], limit = 5
 * Output: 4
 * Explanation: 4 boats (3), (3), (4), (5)
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= people.length <= 5 * 104
 * 1 <= people[i] <= limit <= 3 * 104
 */
public class BoatsToSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        int numBoat = 0;
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        while (left <= right ) {
            int sumWeight = people[left] + people[right];
            if (sumWeight <= limit){
                left++;
            }
            right--;
            numBoat++;
        }
        return numBoat;
    }

    public static void main(String[] args) {
        int [] people1 = {1,2};
        int [] people2 = {3,2,2,1};
        int [] people3 = {3,5,3,4};

        System.out.println(numRescueBoats(people1,3));
        System.out.println(numRescueBoats(people2,3));
        System.out.println(numRescueBoats(people3,5));
    }
}

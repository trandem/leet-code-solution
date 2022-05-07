package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * 1461. Check If a String Contains All Binary Codes of Size K
 * Medium
 * <p>
 * Share
 * Given a binary string s and an integer k, return true if every binary code of length k is a substring of s. Otherwise, return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "00110110", k = 2
 * Output: true
 * Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indices 0, 1, 3 and 2 respectively.
 * Example 2:
 * <p>
 * Input: s = "0110", k = 1
 * Output: true
 * Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring.
 * Example 3:
 * <p>
 * Input: s = "0110", k = 2
 * Output: false
 * Explanation: The binary code "00" is of length 2 and does not exist in the array.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 5 * 105
 * s[i] is either '0' or '1'.
 * 1 <= k <= 20
 */
public class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    public static boolean hasAllCodes(String s, int k) {
        Set<String> data = new HashSet<>();
        int total = 1 << k;
        for (int i = 0; i <= s.length() - k; i++) {
            data.add(s.substring(i, i+k));
        }
        return data.size()==total;
    }

    public static void main(String[] args) {
        String s = "00110110";
        int k = 2;
        System.out.println(hasAllCodes(s,k));
    }
}

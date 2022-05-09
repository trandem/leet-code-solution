package problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 1048. Longest String Chain
 * <p>
 * You are given an array of words where each word consists of lowercase English letters.
 * <p>
 * wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.
 * <p>
 * For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
 * A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
 * <p>
 * Return the length of the longest possible word chain with words chosen from the given list of words.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
 * Example 2:
 * <p>
 * Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 * Output: 5
 * Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
 * Example 3:
 * <p>
 * Input: words = ["abcd","dbqca"]
 * Output: 1
 * Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
 * ["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] only consists of lowercase English letters.
 */

public class LongestStringChain {

    public static int longestStrChain(String[] words) {
        int longestChain = Integer.MIN_VALUE;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> dp = new HashMap<>();
        for (String word : words) {
            dp.put(word, 1);
            int localMax = 1;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                String previous = builder.deleteCharAt(i).toString();
                if (dp.containsKey(previous)){
                    int countP = dp.get(previous);
                    localMax = Math.max(localMax,countP+1);
                }
            }
            dp.put(word,localMax);
            longestChain = Math.max(localMax,longestChain);
        }

        return longestChain;
    }

    public static void main(String[] args) {
        String[] words = {"a","b","ba","bca","bda","bdca"};
        System.out.println(longestStrChain(words));
    }
}

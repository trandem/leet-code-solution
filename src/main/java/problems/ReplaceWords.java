package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 648. Replace Words
 * Medium
 * <p>
 * Share
 * In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word successor.
 * For example, when the root "an" is followed by the successor word "other", we can form a new word "another".
 * <p>
 * Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces,
 * replace all the successors in the sentence with the root forming it. If a successor can be replaced by more than one root,
 * replace it with the root that has the shortest length.
 * <p>
 * Return the sentence after the replacement.
 * <p>
 * Example 1:
 * <p>
 * Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 * Example 2:
 * <p>
 * Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * Output: "a a b c"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] consists of only lower-case letters.
 * 1 <= sentence.length <= 106
 * sentence consists of only lower-case letters and spaces.
 * The number of words in sentence is in the range [1, 1000]
 * The length of each word in sentence is in the range [1, 1000]
 * Every two consecutive words in sentence will be separated by exactly one space.
 * sentence does not have leading or trailing spaces.
 */

public class ReplaceWords {

    public static String replaceWords(List<String> dictionary, String sentence) {
        TreeNode root = new TreeNode();

        for (String word : dictionary) {
            TreeNode temp = root;
            for (char c : word.toCharArray()) {
                if (temp.children[c - 'a'] == null) {
                    temp.children[c - 'a'] = new TreeNode();
                }
                temp = temp.children[c - 'a'];
            }
            temp.setVal(word);
        }

        StringBuilder builder = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            TreeNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] != null && node.val ==null) {
                    node = node.children[c - 'a'];
                } else {
                    break;
                }
            }
            builder.append(node.val != null ? node.val : word).append(" ");
        }
        return builder.toString().trim();
    }

    public static class TreeNode {
        String val;
        TreeNode[] children;

        public TreeNode() {
            children = new TreeNode[26];
        }

        public void setVal(String val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        List<String > dictionary =  new ArrayList<>(Arrays.asList("a", "aa", "aaa", "aaaa")) ;
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        System.out.println(replaceWords(dictionary,sentence));
    }
}

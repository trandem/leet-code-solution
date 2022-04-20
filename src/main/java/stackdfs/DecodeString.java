package stackdfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Decode String
 * <p>
 * Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 * <p>
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 * <p>
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 */
public class DecodeString {
    /**
     * chua xong
     * @param s
     * @return
     */
    public String decodeString(String s) {
        StringBuilder builder = new StringBuilder();

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                stack.push(c);
            }
            if (c == ']') {
                StringBuilder st = new StringBuilder();
                StringBuilder number = new StringBuilder();
                while (!stack.isEmpty()) {
                    char ct = stack.pop();
                    if (isCharacter(ct)) {
                        st.insert(0, ct);
                    }
                    if (ct >= '0' && ct <= '9') {
                        number.insert(0, ct);
                        Character next = stack.peek();
                        if (!isNumber(next)) {
                            int realNumber = Integer.parseInt(number.toString());
                            String  realString = st.toString() + builder.toString();
                            builder = new StringBuilder();
                            for (int i =0 ; i< realNumber ; i++){
                                builder.insert(0,realString);
                            }
                            st = new StringBuilder();
                            number = new StringBuilder();
                        }
                    }
                }
            }
        }
        return builder.toString();
    }

    public boolean isNumber(Character ct) {
        if (ct == null) return false;
        return ct >= '0' && ct <= '9';
    }

    public boolean isCharacter(Character ct) {
        if (ct == null) return false;
        return ct >= 'a' && ct <= 'z';
    }

    public static void main(String[] args) {
        String test = "2[abc]3[cd]ef";

        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString(test));
    }
}

package stackdfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Valid Parentheses
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: s = "(]"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        Deque<Character> charStack = new ArrayDeque<>();

        for (Character c : s.toCharArray()) {
            if (c == ']' || c == '}' || c == ')') {
                if (charStack.isEmpty()) {
                    return false;
                } else {
                    char openChar = charStack.pop();
                    if (c == ']' && openChar != '[') {
                        return false;
                    }
                    if (c == '}' && openChar != '{') {
                        return false;
                    }
                    if (c == ')' && openChar != '(') {
                        return false;
                    }
                }
            } else {
                charStack.push(c);
            }

        }
        return charStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("(){"));
    }
}

package stackdfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Evaluate Reverse Polish Notation
 * <p>
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 * <p>
 * Note that division between two integers should truncate toward zero.
 * <p>
 * It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * <p>
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * <p>
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= tokens.length <= 104
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {

        Deque<Integer> numberStack = new ArrayDeque<>();

        for (String sym : tokens) {
            if (sym.equals("+") || sym.equals("-") || sym.equals("*") || sym.equals("/")) {
                if (numberStack.isEmpty()) return 0;

                switch (sym) {
                    case "+":
                        int x = numberStack.pop();
                        int y = numberStack.pop();
                        int temp = y + x;
                        numberStack.push(temp);
                        break;
                    case "-":
                        int x1 = numberStack.pop();
                        int y1 = numberStack.pop();
                        int temp1 = y1 - x1;
                        numberStack.push(temp1);
                        break;
                    case "*":
                        int x2 = numberStack.pop();
                        int y2 = numberStack.pop();
                        int temp2 = y2 * x2;
                        numberStack.push(temp2);
                        break;
                    case "/":
                        int x3 = numberStack.pop();
                        int y3 = numberStack.pop();
                        int temp3 = y3 / x3;
                        numberStack.push(temp3);
                }
            } else {
                numberStack.push(Integer.parseInt(sym));
            }
        }
        return numberStack.pop();
    }
}

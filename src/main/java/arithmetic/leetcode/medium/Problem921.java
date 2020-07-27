package arithmetic.leetcode.medium;

import java.util.Stack;

/**
 * 921括号有效的最少添加
 */
public class Problem921 {
    public static void main(String[] args) {
//        System.out.println(minAddToMakeValid("())"));
//        System.out.println(minAddToMakeValid("((("));
        System.out.println(minAddToMakeValid(")))"));
        System.out.println(minAddToMakeValid("(())"));
        System.out.println(minAddToMakeValid("()))(("));
    }

    public static int minAddToMakeValid(String S) {
        int len = S.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                stack.push(')');
                continue;
            }

            if (stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(')');
            }
        }

        return stack.size();
    }
}

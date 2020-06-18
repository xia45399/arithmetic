package arithmetic.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class Problem20 {
    public static void main(String[] args) {
        System.out.println(new Problem20().isValid("{}(([()[]]))"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if (c1 == '(' || c1 == '[' || c1 == '{') {
                stack.push(c1);
                continue;
            }
            if (!map.containsKey(c1)) {
                return false;
            }
            if (stack.isEmpty()) {
                return false;
            }

            char leftC = map.get(c1);

            char c2 = stack.pop();
            if (c2 != leftC) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

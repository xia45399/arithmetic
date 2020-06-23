package arithmetic.leetcode.easy;

import java.util.Stack;

public class Problem67 {
    public static void main(String[] args) {
        System.out.println(new Problem67().addBinary("1111", "1111"));
    }

    public String addBinary(String a, String b) {
        Stack<Character> stack1 = toStack(a);
        Stack<Character> stack2 = toStack(b);

        int jinzhi = 0;
        StringBuilder s = new StringBuilder();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int num = jinzhi;
            jinzhi = 0;
            if (!stack1.isEmpty()) {
                num += stack1.pop() - 48;
            }
            if (!stack2.isEmpty()) {
                num += stack2.pop() - 48;
            }
            if (num > 1) {
                num -= 2;
                jinzhi = 1;
            }
            s.append(num);
        }
        if (jinzhi == 1) {
            s.append(1);
        }
        String res = s.reverse().toString();
        return res;
    }

    private Stack<Character> toStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);
        }
        return stack;
    }
}

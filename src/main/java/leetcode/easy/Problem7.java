package leetcode.easy;

/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class Problem7 {
    public static void main(String[] args) {
        System.out.println(new Problem7().reverse(1534236469));
        // TODO: 2018/8/30 时间
    }

    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        if (x < 0) {
            x = -x;
        }
        int newX = 0;
        while (x > 0) {
            int pop = x % 10;
            //Integer.MAX_VALUE 2147483647
            if (newX > 214748364) {
                return 0;
            }
            if (newX == 214748364 && pop > 7) {
                return 0;
            }
            newX = newX * 10 + pop;
            x = x / 10;
        }

        return newX * sign;
    }
}

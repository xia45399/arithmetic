package leetcode.easy;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class Problem13 {
    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        int sum = 0;
        for (int i = 0; i < len; ) {
            char a = arr[i];
            char b = '0';
            if (i + 1 < len) {
                b = arr[i + 1];
            }
            if (a == 'I' && b == 'V') {
                sum += 4;
            } else if (a == 'I' && b == 'X') {
                sum += 9;
            } else if (a == 'X' && b == 'L') {
                sum += 40;
            } else if (a == 'X' && b == 'C') {
                sum += 90;
            } else if (a == 'C' && b == 'D') {
                sum += 400;
            } else if (a == 'C' && b == 'M') {
                sum += 900;
            } else {
                sum += getVal(a);
                i--;
            }
            i = i + 2;
        }

        return sum;
    }

    private int getVal(Character c) {
        int val = 0;
        switch (c) {
            case 'I':
                val = 1;
                break;
            case 'V':
                val = 5;
                break;
            case 'X':
                val = 10;
                break;
            case 'L':
                val = 50;
                break;
            case 'C':
                val = 100;
                break;
            case 'D':
                val = 500;
                break;
            case 'M':
                val = 1000;
                break;
        }
        return val;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(new Problem13().romanToInt(s));

    }
}

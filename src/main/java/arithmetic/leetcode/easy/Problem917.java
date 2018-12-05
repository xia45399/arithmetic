package arithmetic.leetcode.easy;

/**
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 * <p>
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 * <p>
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 */
public class Problem917 {

    public static void main(String[] args) {
        String S = "7_28]";
        String a = reverseOnlyLetters(S);
        System.out.println(a);
    }

    private static String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            while (!Character.isLetter(arr[left]) && left < right) {
                left++;
            }
            while (!Character.isLetter(arr[right]) && right > left) {
                right--;
            }
            if (left < right) {
                swap(left, right, arr);
                left++;
                right--;
            }
        }
        return String.valueOf(arr);
    }


    private static void swap(int left, int right, char[] arr) {
        char tem = arr[left];
        arr[left] = arr[right];
        arr[right] = tem;
    }
}

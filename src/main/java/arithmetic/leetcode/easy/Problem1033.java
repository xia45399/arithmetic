package arithmetic.leetcode.easy;

import java.util.Arrays;

public class Problem1033 {
    public static void main(String[] args) {
        new Problem1033().numMovesStones(4, 2, 3);
    }

    public int[] numMovesStones(int a, int b, int c) {
        int arr[] = {a, b, c};
        Arrays.sort(arr);

        //默认其中一边一个空格,直接把另一半放来即最小
        int min = 1;
        if (arr[1] - arr[0] - 1 >= 2 && arr[2] - arr[1] - 1 >= 2) {
            //如果2边的空格个数都至少为2,则左右都要移动
            min = 2;
        } else if (arr[1] - arr[0] - 1 == 0 && arr[2] - arr[1] - 1 == 0) {
            //如果2边都没空格，说明连续，为0
            min = 0;
        }
        //最大值为空点数
        int max = arr[2] - arr[0] - 2;
        return new int[]{min, max};
    }
}

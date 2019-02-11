package arithmetic.leetcode.easy;

import arithmetic.sort.Print;

import java.util.Arrays;

public class Problem977 {
    public static void main(String[] args) {
        int[] A = {-4, -1, 0, 3, 10};
        new Problem977().sortedSquares(A);
        Print.printArr(A);
    }

    public int[] sortedSquares(int[] A) {
        int len = A.length;
        for (int i = 0; i < len; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }
}

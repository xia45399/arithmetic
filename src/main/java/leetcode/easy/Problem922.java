package leetcode.easy;

public class Problem922 {
    public static void main(String[] args) {
        int a[] = {1, 4, 4, 3, 0, 3};
        new Problem922().sortArrayByParityII(a);
        System.out.println(a);
    }

    private int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        int right = len - 1;
        for (int i = 0; i < len; i = i + 2) {
            if (A[i] % 2 != i % 2) {
                for (int j = right; j > 0; j = j - 2) {
                    if (A[j] % 2 != j % 2) {
                        swap(A, i, j);
                        right = j - 2;
                        break;
                    }
                }
            }
        }
        return A;
    }


    private void swap(int[] A, int i, int j) {
        int tem = A[i];
        A[i] = A[j];
        A[j] = tem;
    }
}

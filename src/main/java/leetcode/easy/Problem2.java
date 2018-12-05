package leetcode.easy;

public class Problem2 {
    public static void main(String[] args) {
        int[] A = {2, 2, 1, 1, 1, 2};
        new Problem2().sortArrayByParityII(A);
        System.out.println();
    }

    public int[] sortArrayByParityII(int[] A) {
        int start = 0;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            if (i % 2 == A[i] % 2) {
                continue;
            }
            findAndSwap(A,i,A[i],i);
        }

        return A;
    }

    private void findAndSwap(int[] A, int swapIndex, int findIndex, int findValue) {
        int len = A.length;
        for (int i = len - 1; i > 0; i--) {
            if (i % 2 == findIndex%2 && A[i] % 2 == findValue%2) {
                swap(A, i, swapIndex);
            }
        }
    }

    private void swap(int[] A, int i, int j) {
        int tem = A[i];
        A[i] = A[j];
        A[j] = tem;
    }
}

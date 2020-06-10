package arithmetic.sort;

import java.util.Arrays;


public class HeapSortV2 {

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int length = arr.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            //从下往上开始构建大顶堆。
            // 构建的过程中,会出现因动了上层，需要重新调整，调整体现在在递归里，其实和把最大元素放到最后之后的调整是一个意思
            buildHeap(arr, i, length);
        }
        for (int i = 0; i < length; i++) {
            ArraysUtils.swap(arr, 0, length - 1 - i);
            System.out.println();
            buildHeap(arr, 0, length - 1 - i);
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void buildHeap(int[] arr, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;

        if (left < length && arr[left] > arr[i]) {
            max = left;
        }

        if (right < length && arr[right] > arr[left]) {
            max = right;
        }

        if (arr[i] < arr[max]) {
            ArraysUtils.swap(arr, i, max);
            //动了叶节点,以动的页节点开始看是否需要调整
            System.out.println(Arrays.toString(arr));
            buildHeap(arr, max, length);
        }
    }

}

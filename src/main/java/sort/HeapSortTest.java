package sort;

import java.util.Arrays;

/**
 * 堆排序复习1
 * 重新写堆排序
 */
public class HeapSortTest {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 2, 6, 9, 7, 8, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    private static void sort(int[] arr) {
        int len = arr.length;
        //1.根据初始数组去构造初始堆（构建一个完全二叉树 保证所有的父结点都比它的孩子结点数值大）
        int startNode = len / 2 - 1;
        for (int index = startNode; index >= 0; index--) {
            buildMaxHeap(arr, index, len);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素，j为末尾元素
        for (int j = len - 1; j > 0; j--) {
            //将堆顶元素与末尾元素进行交换
            swap(arr, 0, j);
            //重新对堆进行调整
            buildMaxHeap(arr, 0, j);
        }
    }

    /**
     * @param i      要开始调整的父节点
     * @param length 构建堆的数组范围，如首次构建为数组长度，将最大的数放到末尾后 length要缩小
     */
    private static void buildMaxHeap(int[] arr, int i, int length) {
        int left = i * 2 + 1;
        if (left >= length) {
            return;
        }
        //找到2个子节点最大的那个的下标
        int maxKey = left;
        if (left + 1 < length && arr[left + 1] > arr[left]) {
            maxKey = left + 1;
        }
        if (arr[i] < arr[maxKey]) {
            swap(arr, i, maxKey);
            //一旦发生了调整，要对调整的节点下面的节点判断是否要调整
            buildMaxHeap(arr, maxKey, length);
        }

    }


    /**
     * 交换元素
     */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

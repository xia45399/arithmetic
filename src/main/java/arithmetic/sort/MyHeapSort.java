package arithmetic.sort;

/**
 * 有问题 待调整
 */
public class MyHeapSort {
    public static void main(String[] args) {
//        int[] arr = new int[]{0, 20, 30, 90, 11, 40, 0, 70, 110, 12, 60, 10, 100, 50, 80};
        int[] arr = new int[]{4, 6, 8, 5, 9};
        sort(arr);
        Print.printArr(arr);
    }

    /**
     * 构造出一个大顶堆
     */
    public static void sort(int[] arr) {
        int length = arr.length;
        for (int index = length / 2 - 1; index >= 0; index--) {
            adjust(arr, index, length - 1);
        }

        for (int j = length - 1; j > 0; j--) {
            //将堆顶元素与末尾元素进行交换
            swap(arr, 0, j);
            //重新对堆进行调整
            adjust(arr, 0, j - 1);
//            Print.printArr(arr);
        }
    }

    /**
     * 调整节点
     *
     * @param arr        数组
     * @param startIndex 要调整的节点索引
     * @param endIndex   结束的节点索引
     */
    private static void adjust(int[] arr, int startIndex, int endIndex) {
        int left = 2 * startIndex + 1;
        if (left > endIndex) {
            return;
        }
        int maxIndex = left;
        int right = left + 1;
        if (right > endIndex) {
            right = left;
        }
        if (arr[right] > arr[left]) {
            maxIndex = right;
        }
        if (arr[startIndex] < arr[maxIndex]) {
            swap(arr, startIndex, maxIndex);
            adjust(arr, maxIndex, endIndex);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}

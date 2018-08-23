/**
 * 2 选择排序
 */
public class Sort3 {
    public static void main(String[] args) {
        int[] arr = {34, 223, 52, 7, 256, 1, 67, 8, 123, 200, 65, 8, 93, 12, 4645, 7, 568, 56};
//        int[] arr = {5, 6, 7, 8, 9, 1};
//        int[] arr = {5, 2, 8, 4, 9, 1};
        sort(arr);
    }

    private static void sort(int arr[]) {
        quickSort(0, arr.length - 1, arr);
        print(arr);
    }

    private static void quickSort(int start, int end, int[] arr) {
        if (start >= end) {
            return;
        }
        int nowLeft = start;
        int nowRight = end;
        int key = arr[start];
        while (nowLeft < nowRight) {
            while (nowLeft < nowRight && arr[nowRight] >= key) {
                nowRight--;
            }
            while (nowLeft < nowRight && arr[nowLeft] <= key) {
                nowLeft++;
            }
            swip(nowLeft, nowRight, arr);
        }
        swip(nowLeft, start, arr);
        quickSort(start, nowLeft - 1, arr);
        quickSort(nowLeft + 1, end, arr);

    }

    private static void swip(int i, int j, int[] arr) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

    private static void print(int[] arr) {
        Print.printArr(arr);
    }
}

package sort;

/**
 * 1冒泡排序
 */
public class Sort1 {
    public static void main(String[] args) {
        int[] arr = {34, 223, 52, 7, 256, 1, 67, 8, 123, 200, 65, 8, 93, 12, 4645, 7, 568, 56};
        sort(arr);
    }

    private static void sort(int arr[]) {
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] < arr[i + 1]) {
                    int tem = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tem;
                }
            }
            print(arr);
        }
    }

    private static void print(int[] arr) {
        Print.printArr(arr);
    }
}

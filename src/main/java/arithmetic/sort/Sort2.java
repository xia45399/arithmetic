package arithmetic.sort;

/**
 * 2 选择排序
 */
public class Sort2 {
    public static void main(String[] args) {
//        int[] arr = {34, 223, 52, 7, 256, 1, 67, 8, 123, 200, 65, 8, 93, 12, 4645, 7, 568, 56};
        int[] arr = {5, 2, 8, 4, 9, 1};
        sort(arr);
    }

    private static void sort(int arr[]) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int minInex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[minInex] > arr[j]) {
                    minInex = j;
                }
            }
            //找到最小数的下标，交换 a[i]和该数位置
            int tem = arr[minInex];
            arr[minInex] = arr[i];
            arr[i] = tem;
            print(arr);
        }
    }

    private static void print(int[] arr) {
        Print.printArr(arr);
    }

}

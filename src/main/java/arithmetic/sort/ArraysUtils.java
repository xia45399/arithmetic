package arithmetic.sort;

import java.util.Arrays;

public class ArraysUtils {

    public static void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 交换元素
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}

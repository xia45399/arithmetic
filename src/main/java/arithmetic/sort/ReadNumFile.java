package arithmetic.sort;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;

public class ReadNumFile {
    public static void main(String[] args) throws IOException {
        String fileName = "1.txt";
        LineIterator lineIterator = FileUtils.lineIterator(new File(fileName));
        int top = 10;
        int index = 0;
        int[] arr = new int[top];
        long t1 = System.currentTimeMillis();
        while (lineIterator.hasNext()) {
            int num = Integer.parseInt(lineIterator.nextLine());
//            if (index < top) {
//                arr[index] = num;
//            } else if (index == top) {
//                sort(arr);
//            } else {
//                if (num > arr[0]) {
//                    //比最小的大，需要排序
//                    arr[0] = num;
//                    sort(arr);
//                }
//            }
//            index++;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("耗时" + (t2 - t1));
        Print.printArr(arr);
        System.out.println(isOrder(arr));
    }

    private static boolean isOrder(int[] arr) {
        int last = arr[0];
        for (int i : arr) {
            if (i < last) {
                return false;
            }
            last = i;
        }
        return true;
    }
}

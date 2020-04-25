package arithmetic.sort;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * 创建一行一个数字的文件
 */
public class CreateNumFile {

    public static void main(String[] args) throws IOException {
        String fileName = "1.txt";
        long t1 = System.currentTimeMillis();
        createNumFile(fileName, 500000000);
        long t2 = System.currentTimeMillis();
        System.out.println("耗时" + (t2 - t1) + "ms");
    }

    private static void createNumFile(String fileName, int size) throws IOException {
        Random random = new Random();
        FileOutputStream outputStream = FileUtils.openOutputStream(new File(fileName));
        for (int i = 0; i < size; i++) {
            int num = random.nextInt();
            outputStream.write((num + "\n").getBytes());
        }
        outputStream.close();
    }
}

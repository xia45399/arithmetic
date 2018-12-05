package arithmetic.other.waitNotify;

import java.util.List;

public class WaitThread extends Thread {
    private List list;
    private String threadName;

    public WaitThread(List list, String threadName) {
        this.list = list;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (list.size() == 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int size = list.size();
                for (int i = size - 1; i >= 0; i--) {
                    Object o = list.remove(i);
                    System.out.println(threadName + "消费者消费数据 " + o);

                }

            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

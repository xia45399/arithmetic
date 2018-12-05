package arithmetic.other.waitNotify;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NotifyThread extends Thread {
    private List list;


    public NotifyThread(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        int i = 1;
        while (true) {
            synchronized (list) {
                list.add("第" + (i++) + "条消息");
                list.notifyAll();

            }
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

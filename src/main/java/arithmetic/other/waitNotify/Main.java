package arithmetic.other.waitNotify;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        new WaitThread(linkedList, "消费线程1").start();
        new WaitThread(linkedList, "消费线程2").start();
        new NotifyThread(linkedList).start();
    }
}

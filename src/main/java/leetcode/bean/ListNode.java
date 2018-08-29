package leetcode.bean;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void print() {
        System.out.println(val);
        if (next != null) {
            next.print();
        }
    }
}

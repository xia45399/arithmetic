package arithmetic.leetcode.medium;

import arithmetic.leetcode.bean.ListNode;

public class Problem2 {

    public static void main(String[] args) {
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curNode = null;
        //进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            int sum = a + b + carry;
            int val = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(val);

            if (head == null) {
                head = node;
                curNode = node;
            } else {
                curNode.next = node;
                curNode = node;
            }
        }
        if (carry == 1) {
            curNode.next = new ListNode(1);
        }
        return head;
    }
}

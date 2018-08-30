package leetcode.easy;

import leetcode.bean.ListNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Problem21 {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null || l2 != null) {
            Integer a = l1 == null ? null : l1.val;
            Integer b = l2 == null ? null : l2.val;
            ListNode node;
            if (a == null) {
                node = new ListNode(b);
                l2 = l2.next;
            } else if (b == null) {
                node = new ListNode(a);
                l1 = l1.next;
            } else if (a < b) {
                node = new ListNode(a);
                l1 = l1.next;
            } else {
                node = new ListNode(b);
                l2 = l2.next;
            }
            cur.next = node;
            cur = node;
        }
        return head.next;
    }
}

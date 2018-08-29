package leetcode.medium;

import leetcode.bean.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 */
public class Problem19 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode ans = removeNthFromEnd(head, 5);
        ans.print();
//        ans = removeNthFromEnd(head, 2);
//        ans.print();
    }

    private static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode c = head;
        int size = 0;
        while (c != null) {
            size++;
            c = c.next;
        }
        c = head;
        int delIndex = size - n;
        if (delIndex == 0) {
            return head.next;
        }
        int curIndex = 0;
        while (c != null) {
            if (curIndex == delIndex - 1) {
                c.next = c.next.next;
                break;
            } else {
                curIndex++;
                c = c.next;
            }
        }
        return head;
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode myHead = new ListNode(0);
        myHead.next = head;

        int cunN = 0;
        ListNode delPre = myHead;
        while (head != null) {
            if (cunN < n) {
                cunN++;
            }
            if ((cunN == n)) {
                //如果到结尾，答案就是删除当前
                if (head.next == null) {
                    delPre.next = delPre.next.next;
                    break;
                } else {
                    delPre = delPre.next;
                }
            }
            head = head.next;
        }

        return myHead.next;
    }
}

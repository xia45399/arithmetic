package leetcode.medium;

import leetcode.bean.ListNode;

/**
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 * <p>
 * <p>
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *  now  执行用时：7 ms 胜 98.36 % 的 java 提交记录
 */
public class Problem147 {

    public static void main(String[] args) {
        ListNode h = new ListNode(4);
        h.next = new ListNode(2);
        h.next.next = new ListNode(1);
        h.next.next.next = new ListNode(3);
        new Problem147().insertionSortList(h);
        System.out.println();
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode node = cur.next;
            if (node.val < cur.val) {
                cur.next = node.next;
                head = insert(head, node);
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    private ListNode insert(ListNode head, ListNode node) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode cur = start;
        while (cur.next != null) {
            if (node.val < cur.next.val) {
                node.next = cur.next;
                cur.next = node;
                return start.next;
            }
            cur = cur.next;
        }
        cur.next = node;
        return start.next;
    }
}

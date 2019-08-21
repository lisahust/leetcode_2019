package List;

import java.util.List;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        int len = 1;
        ListNode p = head;
        while (p.next != null) {
            len++;
        }

        ListNode delNode = head;
        for (int i = 0; i < len-n-1; ++i) {
            delNode = delNode.next;
        }
        delNode.next = delNode.next.next;
        return head;
    }

    public static void main(String [] args) {
        leetcode19 solution = new leetcode19();

        // 1,2,3,4,5
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i < 6; ++i) {
            node.next = new ListNode(i);
            node = node.next;
        }

        while (head.next != null) {
            System.out.print(head.val);
            head = head.next;
        }

        solution.removeNthFromEnd(head, 2);

        while (head.next != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

}

package List;


import DataStructure.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */

public class leetcode19 {
    /**
     * 该方法遍历了两遍
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }

        ListNode delNode = head;
        if (n == len) {
            return head.next;
        }
        for (int i = 0; i < len-n-1; ++i) {
            delNode = delNode.next;
        }
        delNode.next = delNode.next.next;
        return head;
    }

    /**
     * 用两个指针一次遍历
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        if(head.next == null) {
            return null;
        }

        ListNode node1 = dummy;
        ListNode node2 = dummy;
        for(int i = 0; i < n; ++i) {
            node2 = node2.next;
        }
        while(node2.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }

        if(n == 1) {
            node1.next = null;
        } else {
            node1.next = node1.next.next;
        }

        return dummy.next;
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

        ListNode node2 = head;
        while (node2 != null) {
            System.out.print(node2.val);
            node2 = node2.next;
        }

        solution.removeNthFromEnd(head, 2);

        ListNode node3 = head;
        while (node3 != null) {
            System.out.print(node3.val);
            node3 = node3.next;
        }
    }

}

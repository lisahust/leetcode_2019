package yuanfudao;
import DataStructure.ListNode;

import java.util.LinkedList;

/**
 * 链表相邻元素交换
 */

public class interview02 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}

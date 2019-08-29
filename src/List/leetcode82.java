package List;

import DataStructure.ListNode;

/**
 * List.leetcode82
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 */

public class leetcode82 {
    /**
     * 用递归的思路
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }

        if(head.next != null && head.val == head.next.val) {
            while(head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }

        return head;
    }

    /**
     * 用两个指针，一个快指针，用来跳过重复元素，一个慢指针，用来链接
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy.next;
        ListNode slow = dummy;

        while(fast != null) {
            while(fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            if (slow.next == fast) {
                slow = slow.next;
                fast = fast.next;
            } else {
                // 这里不加slow = slow.next 的原因是不能判断下一个数不是重复元素，所以不能移动慢指针
                slow.next = fast.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }

}

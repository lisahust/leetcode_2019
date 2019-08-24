package com_yuanfudao;
import DataStructure.ListNode;

/**
 * leetcode24
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */

public class leetcode24 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)  return head;
        if (head.next != null && head.val == head.next.val) {
            // 删掉前面所有重复的元素
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        }
        else head.next = deleteDuplicates(head.next);
        return head;
    }
}

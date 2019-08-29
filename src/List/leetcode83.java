package List;

import DataStructure.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 题目描述
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */

public class leetcode83 {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode node = head;
        while(node != null && node.next != null) {
            if(node.val == node.next.val) {
                node.next = node.next.next;
            } else{
                node = node.next;
            }
        }
        return head;
    }

}

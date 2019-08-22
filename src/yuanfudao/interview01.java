package yuanfudao;
import DataStructure.ListNode;

/**
 * 删除链表重复节点
 */

public class interview01 {
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

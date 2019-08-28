package List;

import DataStructure.ListNode;

public class leetcode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }

        int len = 1;
        ListNode node = head;
        while(node.next != null) {
            len++;
            node = node.next;
        }
        node.next = head;

        int step = k % len;
        ListNode node2 = head;
        for(int i = 0; i < len-step; ++i) {
            node2 = node2.next;
        }

        return node2;

    }

    public static void main(String [] args) {
        leetcode61 solution = new leetcode61();

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

        System.out.println("   ");

        ListNode node3 = solution.rotateRight(head, 7);
        while (node3 != null) {
            System.out.print(node3.val);
            node3 = node3.next;
        }
    }

}

public class KthNodeFromEnd {
    /**
     * https://www.lintcode.com/problem/remove-nth-node-from-end-of-list/description?_from=ladder&&fromId=6
     *
     * 给定一个链表，删除链表中倒数第n个节点，返回链表的头节点。
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (n <= 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        for (int i = 1; i < n; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        while (head.next != null) {
            head = head.next;
            p = p.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }
}

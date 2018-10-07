public class ReverseList {
    /**
     * https://www.lintcode.com/problem/reverse-linked-list/description?_from=ladder&&fromId=6
     *
     * 翻转一个链表
     *
     * 样例
     * 给出一个链表1->2->3->null，这个翻转后的链表为3->2->1->null
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if(head == null){
            return null;
        }
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode q = head.next;
        while(q != null){
            head.next = q.next;
            q.next = h.next;
            h.next = q;
            q = head.next;
        }
        return h.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

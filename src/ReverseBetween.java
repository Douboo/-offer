public class ReverseBetween {
    /**
     * https://www.lintcode.com/problem/reverse-linked-list-ii/description?_from=ladder&&fromId=6
     *
     * 翻转链表中第m个节点到第n个节点的部分
     * @param head: ListNode head is the head of the linked list
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        if(head == null || m >= n){
            return head;
        }
        ListNode root = new ListNode(0);
        root.next = head;
        head = root;
        for(int i=0; i<m-1; i++){
            head = head.next;
        }
        ListNode p = head.next;
        ListNode q = p.next;
        for(int i=m; i<n; i++){
            p.next = q.next;
            q.next = head.next;
            head.next = q;
            q = p.next;
        }
        return root.next;

    }
}

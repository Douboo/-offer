public class HasCycle {
    /**
     * https://www.lintcode.com/problem/linked-list-cycle/description?_from=ladder&&fromId=6
     *
     * 给定一个链表，判断它是否有环
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        if(head == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}

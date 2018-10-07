public class DetectCycle {
    /**
     * https://www.lintcode.com/problem/linked-list-cycle-ii/description?_from=ladder&&fromId=6
     *
     * 给定一个链表，如果链表中存在环，则返回到链表中环的起始节点，如果没有环，返回null。
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        // write your code here
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(fast.next == null || fast.next.next == null){
            return null;
        }
        int circleLen = 0;
        do{
            fast = fast.next;
            circleLen++;
        }while(fast != slow);
        fast = head;
        slow = head;
        for(int i=0; i<circleLen; i++){
            fast = fast.next;
        }
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}

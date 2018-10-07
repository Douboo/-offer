public class MergeSortedLists {
    /**
     * https://www.lintcode.com/problem/merge-two-sorted-lists/description?_from=ladder&&fromId=6
     *
     * 将两个排序链表合并为一个新的排序链表
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode head = l1;
        ListNode last = l1;
        ListNode dummy = new ListNode(0);
        dummy.next = l2;
        ListNode q = l2;
        l2 = dummy;
        if(q.val < last.val){
            l2.next = q.next;
            q.next = last;
            head = q;
            q = l2.next;
        }
        ListNode before = head;
        while(q != null && last != null){
            if(q.val < last.val){
                l2.next = q.next;
                q.next = last;
                before.next = q;
                before = q;
                q = l2.next;
            }else{
                before = last;
                last = last.next;
            }
        }
        if(q != null){
            before.next = q;
        }
        return head;
    }
}

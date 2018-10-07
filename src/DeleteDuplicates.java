public class DeleteDuplicates {
    /**
     * https://www.lintcode.com/problem/remove-duplicates-from-sorted-list/description?_from=ladder&&fromId=6
     *
     * 给定一个排序链表，删除所有重复的元素每个元素只留下一个。
     * @param head: head is the head of the linked list
     * @return: head of linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(head == null){
            return null;
        }
        ListNode p = head;
        ListNode q = head.next;
        while(q != null){
            if(p.val == q.val){
                p.next = q.next;
            }else{
                p = q;
            }
            q = q.next;
        }
        return head;
    }
}

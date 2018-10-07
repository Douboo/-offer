public class DeleteDuplicatesNoRest {
    /**
     * https://www.lintcode.com/problem/remove-duplicates-from-sorted-list-ii/description?_from=ladder&&fromId=6
     *
     * 给定一个排序链表，删除所有重复的元素只留下原链表中没有重复的元素。
     *
     * 样例
     * 给出 1->2->3->3->4->4->5->null，返回 1->2->5->null
     *
     * 给出 1->1->1->2->3->null，返回 2->3->null
     * @param head: head is the head of the linked list
     * @return: head of the linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(head == null){
            return null;
        }
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode p = preHead;
        ListNode q = head;
        while(q != null){
            if(q.next == null || q.val != q.next.val){
                p = q;
            }
            while(q.next != null && q.val == q.next.val){
                q = q.next;
            }
            p.next = q.next;
            q = q.next;
        }
        return preHead.next;
    }
}

public class FirstCommonNodesInLists {
    /**
     * https://www.lintcode.com/problem/intersection-of-two-linked-lists/description?_from=ladder&&fromId=6
     *
     * 找到两个单链表最开始的交叉节点。
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here
        if(headA == null || headB == null){
            return null;
        }
        int longListLength = 0;
        int shortListLength = 0;
        ListNode longList = headA;
        ListNode shortList = headB;
        while(longList != null){
            longList = longList.next;
            longListLength++;
        }
        while(shortList != null){
            shortList = shortList.next;
            shortListLength++;
        }
        int dist = longListLength - shortListLength;
        longList = headA;
        shortList = headB;
        if(shortListLength > longListLength){
            dist = shortListLength - longListLength;
            longList = headB;
            shortList = headA;
        }
        for(int i=0; i<dist; i++){
            longList = longList.next;
        }
        while(longList != null && longList != shortList){
            longList = longList.next;
            shortList = shortList.next;
        }
        return longList;
    }
}

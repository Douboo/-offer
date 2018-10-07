public class DeleteNode {
    /**
     * https://www.lintcode.com/problem/delete-node-in-a-linked-list/description?_from=ladder&&fromId=6
     *
     * 给定一个单链表中的一个等待被删除的节点(非表头或表尾)。请在在O(1)时间复杂度删除该链表节点。
     * @param node: the node in the list should be deletedt
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

public class BSTToDoublyList {
    /**
     * https://www.lintcode.com/problem/convert-binary-search-tree-to-doubly-linked-list/description?_from=ladder&&fromId=6
     *
     * 将一个二叉查找树按照中序遍历转换成双向链表。
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        ResultType result = helper(root);
        return result.head;
    }
    class ResultType {
        DoublyListNode head = null;
        DoublyListNode tail = null;
        public ResultType(DoublyListNode head, DoublyListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(null, null);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        ResultType curr = new ResultType(null, null);
        DoublyListNode node = new DoublyListNode(root.val);

        if (left.head != null) {
            left.tail.next = node;
            node.prev = left.tail;
            curr.head = left.head;
        } else {
            curr.head = node;
        }

        if (right.head != null) {
            node.next = right.head;
            right.head.prev = node;
            curr.tail = right.tail;
        } else {
            curr.tail = node;
        }

        return curr;
    }
}
class DoublyListNode {
    int val;
    DoublyListNode next, prev;
    DoublyListNode(int val) {
        this.val = val;
        this.next = this.prev = null;
    }
}

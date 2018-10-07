public class LowestCommonAncestor {
    /**
     * https://www.lintcode.com/problem/lowest-common-ancestor-of-a-binary-tree/description?_from=ladder&&fromId=6
     *
     * 给定一棵二叉树，找到两个节点的最近公共父节点(LCA)。
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ListTreeNode headA = new ListTreeNode(root);
        ListTreeNode headB = new ListTreeNode(root);
        recursive(root, A, headA);
        recursive(root, B, headB);
        ListTreeNode p = headA;
        while(headA != null && headB != null && headA.TNode == headB.TNode){
            p = headA;
            headA = headA.next;
            headB = headB.next;
        }
        return p.TNode;


    }
    public boolean recursive(TreeNode root, TreeNode node, ListTreeNode list){
        if(root == null){
            return false;
        }
        ListTreeNode lNode = new ListTreeNode(root);
        list.next = lNode;
        if(root == node){
            return true;
        }
        boolean flag = recursive(root.left, node, list.next);
        if(!flag){
            flag = recursive(root.right, node, list.next);
        }
        if(!flag){
            list.next = null;
        }
        return flag;
    }
}
class ListTreeNode{
    public TreeNode TNode;
    public ListTreeNode next;
    ListTreeNode(TreeNode TNode){
        this.TNode = TNode;
    }
}

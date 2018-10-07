public class CloneTree {
    /**
     * https://www.lintcode.com/problem/clone-binary-tree/description?_from=ladder&&fromId=6
     *
     * 深度复制一个二叉树。
     * @param root: The root of binary tree
     * @return: root of new tree
     */
    public TreeNode cloneTree(TreeNode root) {
        // write your code here
        if(root == null){
            return null;
        }
        TreeNode head = new TreeNode(root.val);
        head.left = cloneTree(root.left);
        head.right = cloneTree(root.right);
        return head;
    }
}

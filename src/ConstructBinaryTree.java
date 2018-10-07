public class ConstructBinaryTree {
    /**
     * https://www.lintcode.com/problem/construct-binary-tree-from-preorder-and-inorder-traversal/description?_from=ladder&&fromId=6
     *
     * 前序遍历和中序遍历树构造二叉树
     * @param inorder: A list of integers that inorder traversal of a tree
     * @param preorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder){
        // write your code here
        if(preorder == null || inorder == null || preorder.length != inorder.length){
            return null;
        }
        return patition(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    public TreeNode patition(int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn){
        TreeNode root = null;
        if(startPre <= endPre){
            int p = preorder[startPre];
            root = new TreeNode(p);
            int idx = startIn;
            while(idx <= endIn && inorder[idx] != p){
                idx++;
            }
            int leftLen = idx - startIn;
            root.left = patition(preorder, startPre+1, startPre+leftLen, inorder, startIn, idx-1);
            root.right = patition(preorder, startPre+leftLen+1, endPre, inorder, idx+1, endIn);
        }
        return root;
    }
}
class TreeNode {
    public int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}


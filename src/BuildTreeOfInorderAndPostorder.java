public class BuildTreeOfInorderAndPostorder {
    /**
     * https://www.lintcode.com/problem/construct-binary-tree-from-inorder-and-postorder-traversal/description?_from=ladder&&fromId=6
     *
     * 根据中序遍历和后序遍历树构造二叉树
     * @param inorder: A list of integers that inorder traversal of a tree
     * @param postorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length){
            return null;
        }
        TreeNode root = buildTreeRecursive(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        return root;
    }
    public TreeNode buildTreeRecursive(int[] inorder, int startIn, int endIn, int[] postorder, int startPost, int endPost){
        if(startIn > endIn){
            return null;
        }
        int pRoot = postorder[endPost];
        TreeNode root = new TreeNode(pRoot);
        int idx = startIn;
        while(idx <= endIn && inorder[idx] != pRoot){
            idx++;
        }
        if(idx > endIn){
            return null;
        }
        int rightLength = endIn - idx;
        root.right = buildTreeRecursive(inorder, idx+1, idx+rightLength, postorder, endPost-rightLength, endPost-1);
        root.left = buildTreeRecursive(inorder, startIn, idx-1, postorder, startPost, endPost-rightLength-1);
        return root;

    }
}

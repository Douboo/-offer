import java.util.*;
public class InorderTravel {
    /**
     * https://www.lintcode.com/problem/binary-tree-inorder-traversal/description?_from=ladder&&fromId=6
     *
     * 给出一棵二叉树,返回其中序遍历
     *
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while(p != null || !stack.isEmpty()){
            while(p != null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            result.add(p.val);
            p = p.right;
        }
        return result;
    }
}

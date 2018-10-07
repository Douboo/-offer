import java.util.*;
public class PreorderTravel {
    /**
     * https://www.lintcode.com/problem/binary-tree-preorder-traversal/description?_from=ladder&&fromId=6
     *
     * 给出一棵二叉树，返回其节点值的前序遍历。
     *
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        if(root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                list.add(root.val);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }
}

import java.util.*;
public class PostTravel {
    /**
     * https://www.lintcode.com/problem/binary-tree-postorder-traversal/description?_from=ladder&&fromId=6
     *
     * 给出一棵二叉树，返回其节点值的后序遍历。
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode lastVisited = null;
        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.peek();
            if(current.right == null || current.right == lastVisited){
                list.add(current.val);
                stack.pop();
                lastVisited = current;
                current = null;
            }else{
                current = current.right;
            }
        }
        return list;
    }
}

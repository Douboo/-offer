import java.util.*;
public class ZigzagLevelOrder {
    /**
     * https://www.lintcode.com/problem/binary-tree-zigzag-level-order-traversal/description?_from=ladder&&fromId=6
     *
     * 给出一棵二叉树，返回其节点值的锯齿形层次遍历（先从左往右，下一层再从右往左，层与层之间交替进行）即之字形
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其锯齿形的层次遍历为：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode>[] stack = new Stack[2];
        int current = 0;
        int next = 1;
        stack[0] = new Stack<>();
        stack[1] = new Stack<>();
        stack[0].push(root);
        while(!stack[0].isEmpty() || !stack[1].isEmpty()){
            TreeNode p = stack[current].pop();
            list.add(p.val);
            if(current == 0){
                if(p.left != null){
                    stack[next].push(p.left);
                }
                if(p.right != null){
                    stack[next].push(p.right);
                }
            }else{
                if(p.right != null){
                    stack[next].push(p.right);
                }
                if(p.left != null){
                    stack[next].push(p.left);
                }
            }
            if(stack[current].isEmpty()){
                current = 1 - current;
                next = 1 - next;
                result.add(list);
                list = new ArrayList<>();
            }
        }
        return result;
    }
}

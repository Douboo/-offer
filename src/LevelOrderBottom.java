import java.util.*;
public class LevelOrderBottom {
    /**
     * https://www.lintcode.com/problem/binary-tree-level-order-traversal-ii/description?_from=ladder&&fromId=6
     *
     * 给出一棵二叉树，返回其节点值从底向上的层次序遍历（按从叶节点所在层到根节点所在的层遍历，然后逐层从左往右遍历）
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        List<List<Integer>> llist = new ArrayList<>();
        if(root != null){
            Stack<List<Integer>> stack = new Stack<>();
            Queue<TreeNode> que = new LinkedList<>();
            que.offer(root);
            while(!que.isEmpty()){
                int size = que.size();
                List<Integer> list = new ArrayList<>();
                for(int i=0; i<size; i++){
                    TreeNode p = que.poll();
                    list.add(p.val);
                    if(p.left != null){
                        que.offer(p.left);
                    }
                    if(p.right != null){
                        que.offer(p.right);
                    }
                }
                stack.push(list);
            }
            while(!stack.isEmpty()){
                llist.add(stack.pop());
            }

        }
        return llist;
    }
}

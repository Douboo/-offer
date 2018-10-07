import java.util.*;
public class LevelTravel {
    /**
     * https://www.lintcode.com/problem/binary-tree-level-order-traversal/description?_from=ladder&&fromId=6
     *
     * 给出一棵二叉树，返回其节点值的层次遍历（逐层从左往右访问）
     * 样例
     * 给一棵二叉树 {3,9,20,#,#,15,7} ：
     *
     *   3
     *  / \
     * 9  20
     *   /  \
     *  15   7
     * 返回他的分层遍历结果：
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> llist = new ArrayList<>();
        if(root == null){
            return llist;
        }
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode p = root;
        que.offer(p);
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                p = que.poll();
                list.add(p.val);
                if(p.left != null){
                    que.offer(p.left);
                }
                if(p.right != null){
                    que.offer(p.right);
                }
            }
            llist.add(list);
        }
        return llist;
    }
}

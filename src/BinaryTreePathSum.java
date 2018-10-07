import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum {
    /**
     * https://www.lintcode.com/problem/binary-tree-path-sum/description?_from=ladder&&fromId=6
     *
     * 给定一个二叉树，找出所有路径中各节点相加总和等于给定 目标值 的路径。
     *
     * 一个有效的路径，指的是从根节点到叶节点的路径。
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> llist = new ArrayList<>();
        if(root != null){
            int currentSum = 0;
            List<Integer> list = new ArrayList<>();
            findPath(root, llist, list, target, currentSum);
        }
        return llist;
    }
    public void findPath(TreeNode root, List<List<Integer>> llist, List<Integer> list,  int target, int currentSum){
        if(root == null){
            return;
        }
        list.add(root.val);
        currentSum += root.val;
        if(target == currentSum && root.left == null && root.right == null){
            List<Integer> copy = new ArrayList<>();
            for(int i=0; i<list.size(); i++){
                copy.add(list.get(i));
            }
            llist.add(copy);
        }
        if(root.left != null){
            findPath(root.left, llist, list, target, currentSum);
        }
        if(root.right != null){
            findPath(root.right, llist, list, target, currentSum);
        }
        list.remove(list.size()-1);
    }
}

public class SubstructureInTree {
    /**
     * https://www.lintcode.com/problem/subtree/description?_from=ladder&&fromId=6
     *
     * 有两个不同大小的二叉树： T1 有上百万的节点； T2 有好几百的节点。请设计一种算法，判定 T2 是否为 T1的子树。
     * @param T1: The roots of binary tree T1.
     * @param T2: The roots of binary tree T2.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if(T2 == null){
            return true;
        }
        boolean result = false;
        if(T1 != null && T2 != null){
            if(T1.val == T2.val){
                result = doesT1HaveT2(T1, T2);
            }
            if(!result){
                result = isSubtree(T1.left, T2);
            }
            if(!result){
                result = isSubtree(T1.right, T2);
            }
        }
        return result;
    }
    public boolean doesT1HaveT2(TreeNode T1, TreeNode T2){
        if(T1 == null && T2 == null){
            return true;
        }
        if(T1 == null || T2 == null){
            return false;
        }
        if(T1.val != T2.val){
            return false;
        }
        return doesT1HaveT2(T1.left, T2.left) && doesT1HaveT2(T1.right, T2.right);
    }
}

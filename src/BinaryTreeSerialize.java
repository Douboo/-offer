import java.util.*;
public class BinaryTreeSerialize {
    /**
     * https://www.lintcode.com/problem/serialize-and-deserialize-binary-tree/description?_from=ladder&&fromId=6
     *
     * 设计一个算法，并编写代码来序列化和反序列化二叉树。将树写入一个文件被称为“序列化”，读取文件后重建同样的二叉树被称为“反序列化”。
     *
     * 如何反序列化或序列化二叉树是没有限制的，你只需要确保可以将二叉树序列化为一个字符串，并且可以将字符串反序列化为原来的树结构。
     *
     * 样例
     * 给出一个测试数据样例， 二叉树{3,9,20,#,#,15,7}，表示如下的树结构：
     *
     *   3
     *  / \
     * 9  20
     *   /  \
     *  15   7
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if(root == null){
            return null;
        }
        TreeNode NULL = new TreeNode(Integer.MAX_VALUE);
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        StringBuilder sbd = new StringBuilder();
        while(!que.isEmpty()){
            TreeNode p = que.poll();
            if(p == NULL){
                sbd.append("#,");
                continue;
            }
            sbd.append(p.val + ",");
            if(p.left != null){
                que.offer(p.left);
            }else{
                que.offer(NULL);
            }
            if(p.right != null){
                que.offer(p.right);
            }else{
                que.offer(NULL);
            }
        }
        System.out.println(sbd.toString());
        return sbd.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if(data == null){
            return null;
        }
        String[] str = data.split(",");
        Queue<TreeNode> que = new LinkedList<>();
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(str[index]));
        que.offer(root);
        while(!que.isEmpty()){
            TreeNode p = que.poll();
            if(++index < str.length && !str[index].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(str[index]));
                p.left = left;
                que.offer(left);
            }
            if(++index < str.length && !str[index].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(str[index]));
                p.right = right;
                que.offer(right);
            }
        }
        return root;
    }
}

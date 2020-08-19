package 二叉树.L114二叉树展开为链表;

import 数据结构类.TreeNode;

public class Solution1 {
    private TreeNode p = new TreeNode(0);//前序遍历节点记录

    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode temp = root.right;
        p.left = null;//断开所有节点的左子树
        p.right = root;//right相当于next
        p = p.right;
        flatten(root.left);
        flatten(temp);
    }
}

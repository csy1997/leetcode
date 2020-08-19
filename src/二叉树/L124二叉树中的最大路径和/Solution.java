package 二叉树.L124二叉树中的最大路径和;

import 数据结构类.TreeNode;

public class Solution {
    private int max;

    public int maxPathSum(TreeNode root) {
        this.max = Integer.MIN_VALUE;
        getMaxPathSum(root);
        return max;
    }

    public int getMaxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftPath = Math.max(0, getMaxPathSum(root.left));//递归求出root沿左子树往下的最长路径，不包括root，如果为负则不加左孩子
        int rightPath = Math.max(0, getMaxPathSum(root.right));//递归求出root沿右子树往下的最长路径，不包括root，如果为负则不加右孩子
        max = Math.max(max, leftPath + rightPath + root.val);//通过root合并左右路径，得到的新路径为root子树里经过root节点的最长路径，与max比较
        return root.val + Math.max(leftPath, rightPath);//返回以root为起点往下的最长路径，包括root
    }
}

package 二叉树.L110平衡二叉树;

import 数据结构类.TreeNode;

public class Solution {
    private boolean res;

    public boolean isBalanced(TreeNode root) {
        this.res = true;
        getHeight(root);
        return res;
    }

    public int getHeight(TreeNode root) {
        if(!res) {
            return -1;
        }
        if(root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if((leftHeight-rightHeight > 1) || (rightHeight-leftHeight > 1)) {
            res = false;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

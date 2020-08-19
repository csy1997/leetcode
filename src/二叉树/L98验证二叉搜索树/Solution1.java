package 二叉树.L98验证二叉搜索树;

import 数据结构类.TreeNode;

public class Solution1 {
    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer leftBound, Integer rightBound) {//用null防止临界取值问题
        if(root == null) {
            return true;
        }
        if((leftBound != null && root.val <= leftBound) || (rightBound != null && root.val >= rightBound)) {
            return false;
        }
        return isValidBST(root.left, leftBound, root.val) && isValidBST(root.right, root.val, rightBound);
    }
}

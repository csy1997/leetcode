package 二叉树.L98验证二叉搜索树;

import 数据结构类.TreeNode;

/**
 * 中序遍历相邻比较
 */
public class Solution2 {
    private Integer value;

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(!isValidBST(root.left)) {
            return false;
        }
        if(value != null && root.val <= value) {
            return false;
        }
        value = root.val;
        return isValidBST(root.right);
    }
}

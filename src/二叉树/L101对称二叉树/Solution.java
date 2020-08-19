package 二叉树.L101对称二叉树;

import 数据结构类.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSym(root, root);
    }

    public boolean isSym(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSym(p.left, q.right) && isSym(p.right, q.left);
    }
}

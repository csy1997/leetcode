package 二叉树.L99恢复二叉搜索树;

import 数据结构类.TreeNode;

public class Solution {
    private TreeNode current;

    public void recoverTree(TreeNode root) {
        TreeNode left = findLeft(root);
        current = null;
        TreeNode right = findRight(root);
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
    }

    public TreeNode findLeft(TreeNode root) {//从左到右找第一个递减的位置，返回大的数
        if(root == null) {
            return null;
        }
        TreeNode temp = findLeft(root.left);
        if(temp != null) {
            return temp;
        }
        if(current != null && root.val < current.val) {
            return current;
        }
        current = root;
        return findLeft(root.right);
    }

    public TreeNode findRight(TreeNode root) {//从右到左找第一个递增的位置，返回小的数
        if(root == null) {
            return null;
        }
        TreeNode temp = findRight(root.right);
        if(temp != null) {
            return temp;
        }
        if(current != null && root.val > current.val) {
            return current;
        }
        current = root;
        return findRight(root.left);
    }
}

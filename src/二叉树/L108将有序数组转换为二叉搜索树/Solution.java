package 二叉树.L108将有序数组转换为二叉搜索树;

import 数据结构类.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int l, int r) {
        if (l == r + 1) {
            return null;
        }
        int mid = (l + r + 1) / 2;//int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, l, mid - 1);
        root.right = buildTree(nums, mid + 1, r);
        return root;
    }
}

package 二叉树.L103二叉树的锯齿形层次遍历;

import 数据结构类.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            List<Integer> nums = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {//在遍历的同时把下一行的节点倒过来加入队列
                TreeNode temp = queue.remove(0);
                nums.add(temp.val);
                if(flag) {
                    if(temp.left != null) {
                        queue.add(len-1-i, temp.left);
                    }
                    if(temp.right != null) {
                        queue.add(len-1-i, temp.right);
                    }
                } else {
                    if(temp.right != null) {
                        queue.add(len-1-i, temp.right);
                    }
                    if(temp.left != null) {
                        queue.add(len-1-i, temp.left);
                    }
                }
            }
            flag = !flag;
            res.add(nums);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        Solution2 sol = new Solution2();
        System.out.println(sol.zigzagLevelOrder(root));
    }
}

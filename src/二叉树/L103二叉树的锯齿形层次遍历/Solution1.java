package 二叉树.L103二叉树的锯齿形层次遍历;

import 数据结构类.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            List<Integer> nums = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.remove(0);
                nums.add(temp.val);
                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }
            if(flag) {
                Collections.reverse(nums);
            }
            flag = !flag;
            res.add(nums);
        }
        return res;
    }
}

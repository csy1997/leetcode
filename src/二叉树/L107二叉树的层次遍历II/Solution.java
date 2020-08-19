package 二叉树.L107二叉树的层次遍历II;

import 数据结构类.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        this.res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        levelOrderBottom(new ArrayList<>(){{
            add(root);
        }});
        return res;
    }

    public void levelOrderBottom(List<TreeNode> queue) {
        if(queue.size() == 0) {
            return;
        }
        List<Integer> nums = new ArrayList<>();
        int len = queue.size();
        for (int i = 0; i < len; i++) {
            TreeNode node = queue.remove(0);
            nums.add(node.val);
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        levelOrderBottom(queue);
        res.add(nums);
    }
}

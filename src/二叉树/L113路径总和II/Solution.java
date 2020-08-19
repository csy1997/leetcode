package 二叉树.L113路径总和II;

import 数据结构类.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.res = new ArrayList<>();
        addToList(root, sum, new ArrayList<>());
        return res;
    }

    public void addToList(TreeNode root, int sum, List<Integer> list) {
        if(root == null) {
            return;
        }
        sum -= root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if(sum == 0) {
                res.add((List) ((ArrayList)list).clone());
            }
        } else {
            addToList(root.left, sum, list);
            addToList(root.right, sum, list);
        }
        list.remove(list.size()-1);
    }
}

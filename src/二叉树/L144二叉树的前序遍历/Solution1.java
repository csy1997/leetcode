package 二叉树.L144二叉树的前序遍历;

import 数据结构类.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归
 */
public class Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        preorderTraversal(res, root);
        return res;
    }

    public void preorderTraversal(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorderTraversal(res, root.left);
        preorderTraversal(res, root.right);
    }
}

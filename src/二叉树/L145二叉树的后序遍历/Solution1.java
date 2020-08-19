package 二叉树.L145二叉树的后序遍历;

import 数据结构类.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归
 */
public class Solution1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        postorderTraversal(res, root);
        return res;
    }

    public void postorderTraversal(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversal(res, root.left);
        postorderTraversal(res, root.right);
        res.add(root.val);
    }
}

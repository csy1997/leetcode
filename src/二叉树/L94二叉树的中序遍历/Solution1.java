package 二叉树.L94二叉树的中序遍历;

import 数据结构类.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归
 */
public class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorderTraversal(res, root);
        return res;
    }

    public void inorderTraversal(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(res, root.left);
        res.add(root.val);
        inorderTraversal(res, root.right);
    }
}

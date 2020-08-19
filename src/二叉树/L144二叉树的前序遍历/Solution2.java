package 二叉树.L144二叉树的前序遍历;

import 数据结构类.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 迭代
 */
public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode peek = st.pop();
            res.add(peek.val);
            if (peek.right != null) {
                st.push(peek.right);
            }
            if (peek.left != null) {
                st.push(peek.left);
            }
        }
        return res;
    }
}

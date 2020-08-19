package 二叉树.L145二叉树的后序遍历;

import 数据结构类.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 迭代
 */
public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while (!st.isEmpty() || node != null) {
            while (node != null) {//一路把当前节点和左子节点压入栈，初始为空就跳过
                st.push(node);
                node = node.left;
            }
            node = st.peek();//栈顶元素为当前树（可能是断开的子树）的最右边元素
            TreeNode right = node.right;
            if (right == null) {//没有右子树（右子树为null）就直接遍历当前节点，并从栈中弹出不再遍历
                res.add(node.val);
                st.pop();
            } else {//有右子树需先遍历右子树，此时不弹出node，并在把right赋给node之前把node与右子树断开，让下次遍历到node时直接遍历弹出
                node.right = null;
            }
            node = right;
        }
        return res;
    }
}

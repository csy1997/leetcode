package 二叉树.L94二叉树的中序遍历;

import com.sun.source.tree.Tree;
import 数据结构类.ListNode;
import 数据结构类.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 迭代
 */
public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while(!st.isEmpty() || node != null) {
            while(node != null) {//一路把当前节点和左子节点压入栈，初始为空就跳过
                st.push(node);
                node = node.left;
            }
            //如果本轮前面有压入栈的左子节点，则遍历最后一个压入栈的节点（上一轮node的右子树的最左非空节点）及其右子树；
            //没有的话说明上一轮node的右子树为空，此时考虑的是node的父节点即前一个压入栈的节点
            node = st.pop();//当当前节点遍历完就可从栈中去除，下一个考虑其右子树
            res.add(node.val);//左边为空或者已经遍历过了，遍历当前节点
            node = node.right;//考虑右子树
        }
        return res;
    }
}

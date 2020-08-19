package 二叉树.L106从中序与后序遍历序列构造二叉树;

import 数据结构类.TreeNode;

import java.util.HashMap;

public class Solution {
    private int[] postorder;
    private int[] inorder;
    private int index;
    private HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        this.index = postorder.length-1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return addNodes(0, inorder.length-1);
    }

    public TreeNode addNodes(int l, int r) {
        if (l == r+1) {
            return null;
        }
        int mid = map.get(postorder[index--]);
        TreeNode root = new TreeNode(inorder[mid]);
        root.right = addNodes(mid+1, r);
        root.left = addNodes(l, mid-1);
        return root;
    }
}

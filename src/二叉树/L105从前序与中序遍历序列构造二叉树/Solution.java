package 二叉树.L105从前序与中序遍历序列构造二叉树;

import 数据结构类.TreeNode;

import java.util.HashMap;

public class Solution {
    private int[] preorder;
    private int[] inorder;
    private int index;//记录preorder的索引，前序遍历依次递增
    private HashMap<Integer, Integer> map = new HashMap<>();//记录inorder中每个数字的索引，避免重复搜索

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.index = 0;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return addNodes(0, inorder.length-1);
    }

    public TreeNode addNodes(int l, int r) {
        if (l == r+1) {
            return null;
        }
        int mid = map.get(preorder[index++]);
        TreeNode root = new TreeNode(inorder[mid]);
        root.left = addNodes(l, mid-1);
        root.right = addNodes(mid+1, r);
        return root;
    }
}

package 数据结构类;

import java.util.ArrayList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        ArrayList<String> res = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        TreeNode node = this;
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove(0);
            if (temp == null) {
                res.add("*");
            } else {
                res.add(String.valueOf(temp.val));
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        return res.toString();
    }

    @Override
    public TreeNode clone() {
        return new TreeNode(this.val, this.left == null ? null : this.left.clone(), this.right == null ? null : this.right.clone());
    }
}

package 二叉树.L116填充每个节点的下一个右侧节点指针;

public class Solution1 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node left = root.left;
        Node right = root.right;
        while (left != null) {//连接root的左右子树各层的相邻的节点，即连接左子树各层最右，右子树各层最左的节点
            left.next = right;
            left = left.right;
            right = right.left;
        }
        //递归考虑子节点
        connect(root.left);
        connect(root.right);
        return root;
    }
}

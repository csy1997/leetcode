package 二叉树.L117填充每个节点的下一个右侧节点指针II;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        List<Node> queue = new ArrayList<>();
        queue.add(root);
        while(queue.size() != 0) {
            List<Node> temp = new ArrayList<>();
            Node p = new Node(0);
            for (Node node : queue) {
                p.next = node;
                p = node;
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            queue = temp;
        }
        return root;
    }
}

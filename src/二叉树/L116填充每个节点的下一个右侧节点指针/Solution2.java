package 二叉树.L116填充每个节点的下一个右侧节点指针;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        List<Node> queue = new ArrayList<>();
        queue.add(root);
        int count = 2;
        int pause = 2;
        while(queue.size() != 0) {
            Node temp = queue.remove(0);
            if(temp.left != null) {
                queue.add(temp.left);
            }
            if(temp.right != null) {
                queue.add(temp.right);
            }
            if(pause == count) {//每层最右节点没有next
                pause *= 2;
            } else {
                temp.next = queue.get(0);
            }
            count++;
        }
        return root;
    }
}

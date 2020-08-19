package 哈希表.L138复制带随机指针的链表;

import java.util.HashMap;

public class Solution {
    HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node node = new Node(head.val);
        map.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = map.get(head.random);
        return node;
    }
}

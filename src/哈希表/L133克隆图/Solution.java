package 哈希表.L133克隆图;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        ArrayList<Node> neighbors = new ArrayList<>();
        Node newNode = new Node(node.val, neighbors);
        map.put(node, newNode);
        for (Node neighbor : node.neighbors) {
            neighbors.add(cloneGraph(neighbor));
        }
        return newNode;
    }
}

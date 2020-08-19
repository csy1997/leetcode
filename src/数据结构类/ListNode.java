package 数据结构类;

import java.util.ArrayList;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode node = this;
        while (node != null) {
            res.add(node.val);
            node = node.next;
        }
        return res.toString();
    }
}

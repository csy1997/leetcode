package 分治法.L23合并K个排序链表;

import org.junit.Before;
import org.junit.Test;
import 数据结构类.ListNode;

public class TestSolution {
    ListNode[] lists;

    @Before
    public void initLists() {
        lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);
    }

    @Test
    public void testSolution1() {
        Solution1 sol = new Solution1();
        System.out.println(sol.mergeKLists(lists));
    }

    @Test
    public void testSolution2() {
        Solution2 sol = new Solution2();
        System.out.println(sol.mergeKLists(lists));
    }
}

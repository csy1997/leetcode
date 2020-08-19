package 分治法.L23合并K个排序链表;

import 数据结构类.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 构造K小顶堆排序的方法
 */
public class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> heap = new ArrayList<>();
        for(ListNode node : lists) {
            //添加不为null的节点到堆heap
            if(node != null) {
                heap.add(node);
            }
        }
        if (heap.size() == 0) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        //构造初始小顶堆
        for(int i = (heap.size()-1)/2; i >= 0; i--) {
            adjustHeap(heap, i, heap.size());
        }
        for (int l = heap.size(); l > 0; ) {
            ListNode temp = heap.get(0);
            //取出堆顶元素排到head表队尾
            p.next = temp;
            p = p.next;
            if(temp.next != null) {
                //堆顶的next不为空就将next设为堆顶，重新调整堆
                heap.set(0, temp.next);
                adjustHeap(heap, 0, l);
            } else {
                //堆顶的next为空就将堆底的元素拿到堆顶，并将堆大小减1，调整堆（即链到尾了排除掉）
                heap.set(0, heap.get(l-1));
                adjustHeap(heap, 0, --l);
            }
        }
        return head.next;
    }

    /**
     * 调整小顶堆
     * @param list
     * @param i
     * @param length
     */
    public static void adjustHeap(List<ListNode> list,int i,int length){
        if(length == 0 || length == 1) {
            return;
        }
        ListNode temp = list.get(i);//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && list.get(k).val>list.get(k+1).val){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(list.get(k).val < temp.val){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                list.set(i, list.get(k));
                i = k;
            }else{
                break;
            }
        }
        list.set(i, temp);//将temp值放到最终的位置
    }
}

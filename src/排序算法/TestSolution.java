package 排序算法;

import org.junit.Test;

import java.util.Arrays;

import static 排序算法.堆排序.Solution.heapSort;
import static 排序算法.归并排序.Solution.mergeSort;
import static 排序算法.快速排序.Solution.quickSort;

public class TestSolution {
    private int[] arr = {7, 8, 9, 1, 3, 4, 5, 2, 6};

    @Test
    public void testQuickSort() {
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void testMergeSort() {
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testHeapSort() {
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

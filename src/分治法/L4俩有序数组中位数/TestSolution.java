package 分治法.L4俩有序数组中位数;

import org.junit.Test;

public class TestSolution {
    private int[] nums1 = {1,4,5,6,6};
    private int[] nums2 = {7,8,9};

    @Test
    public void testSolution1() {
        Solution1 sol = new Solution1();
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testSolution2() {
        Solution2 sol = new Solution2();
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));
    }
}

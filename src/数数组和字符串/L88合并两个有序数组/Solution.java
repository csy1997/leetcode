package 数数组和字符串.L88合并两个有序数组;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        --m;
        --n;
        for (int i = m+n+1; m >= 0 && n >= 0; i--) {//从后往前赋值，由于m一直比i小所以nums1前面未遍历到的不会被新赋的值所覆盖
            if(nums1[m] > nums2[n]) {
                nums1[i] = nums1[m];
                m--;
            } else {
                nums1[i] = nums2[n];
                n--;
            }
        }
        while(n >= 0) {//nums2还有元素未遍历，说明nums1已遍历完，把nums2剩下的加到nums1前；相反若nums1没遍历完，未遍历已存在于nums1不用另加
            nums1[n] = nums2[n];
            n--;
        }
    }
}

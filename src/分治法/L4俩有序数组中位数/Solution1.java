package 分治法.L4俩有序数组中位数;

/**
 * 第一个思路：每次比较俩数组的中位数，去除短数组的一半（不好写）
 */
public class Solution1 {
    int[] nums1;
    int[] nums2;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0) {
            return findMedianSingleArray(nums2, 0, len2 - 1);
        }
        if (len2 == 0) {
            return findMedianSingleArray(nums1, 0, len1 - 1);
        }
        // 使nums1为短数组，nums2长数组
        if (len1 > len2) {
            this.nums1 = nums2;
            this.nums2 = nums1;
        } else {
            this.nums1 = nums1;
            this.nums2 = nums2;
        }
        return findMedianDoubleArrays(0, this.nums1.length - 1, 0, this.nums2.length - 1);
    }

    /**
     * 单个数组的中位数
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private double findMedianSingleArray(int[] nums, int l, int r) {
        int mid = (r + l) / 2;
        if ((r - l) % 2 == 0) {
            return nums[mid];
        }
        return (double) (nums[mid] + nums[mid + 1]) / 2;
    }

    /**
     * 递归每次从俩数组中去掉相同数量且不可能包含中位数的部分
     *
     * @param l1
     * @param r1
     * @param l2
     * @param r2
     * @return
     */
    public double findMedianDoubleArrays(int l1, int r1, int l2, int r2) {
        // 当短数组剩下一个时，递归终止，中位数可通过简单计算得出
        if (l1 == r1) {
            if (l2 == r2) {
                return (double) (nums1[l1] + nums2[l2]) / 2;
            }
            int mid = (l2 + r2) / 2;
            if ((r2 - l2) % 2 == 0) {
                if (nums1[l1] < nums2[mid - 1]) {
                    return (double) (nums2[mid] + nums2[mid - 1]) / 2;
                }
                if (nums1[l1] > nums2[mid + 1]) {
                    return (double) (nums2[mid] + nums2[mid + 1]) / 2;
                }
                return (double) (nums1[l1] + nums2[mid]) / 2;
            }
            if (nums1[l1] < nums2[mid]) {
                return nums2[mid];
            }
            if (nums1[l1] > nums2[mid + 1]) {
                return nums2[mid + 1];
            }
            return nums1[l1];
        }
        // 算出两数组的中间数，奇数长度为一个数（L=R），偶数长度为两个数（L+1=R）
        int L1 = (l1 + r1) / 2;
        int R1 = (r1 - l1) % 2 == 0 ? L1 : L1 + 1;
        int L2 = (l2 + r2) / 2;
        int R2 = (r2 - l2) % 2 == 0 ? L2 : L2 + 1;
        // 每次丢弃短数组的一半，长数组在另一端丢弃与之相同长度，规则如下
        if (nums1[L1] > nums2[R2]) {
            l2 += r1 - L1;
            r1 = L1;
        } else if (nums1[R1] < nums2[L2]) {
            r2 -= R1 - l1;
            l1 = R1;
        } else {
            // 出现中间数重合（区间重合）可直接得出中位数
            return getMedianInFour(L1, R1, L2, R2);
        }
        return findMedianDoubleArrays(l1, r1, l2, r2);
    }

    /**
     * nums1和nums2中间数重合时可直接得出中位数
     *
     * @param L1
     * @param R1
     * @param L2
     * @param R2
     * @return
     */
    public double getMedianInFour(int L1, int R1, int L2, int R2) {
        if (L1 == R1) {
            return nums1[L1];
        }
        if (L2 == R2) {
            return nums2[L2];
        }
        return (double) (Math.max(nums1[L1], nums2[L2]) + Math.min(nums1[R1], nums2[R2])) / 2;
    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        int[] nums1 = {4};
        int[] nums2 = {2, 3};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));
    }
}

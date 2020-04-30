package 分治法;

public class T4俩有序数组中位数 {
    int[] nums1;
    int[] nums2;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 == 0) {
            return findMedianSingleArray(nums2, 0, len2-1);
        }
        if(len2 == 0) {
            return findMedianSingleArray(nums1, 0, len1-1);
        }
        if(len1 > len2) {
            this.nums1 = nums2;
            this.nums2 = nums1;
        } else {
            this.nums1 = nums1;
            this.nums2 = nums2;
        }
        return findMedianDoubleArrays(0, this.nums1.length-1, 0, this.nums2.length-1);
    }

    private double findMedianSingleArray(int[] nums, int l, int r) {
        int mid = (r+l)/2;
        if((r-l)%2 == 0){
            return nums[mid];
        }
        return (double)(nums[mid] + nums[mid+1])/2;
    }

    public double findMedianDoubleArrays(int l1, int r1, int l2, int r2) {
        if(l1 == r1) {
            if(l2 == r2) {
                return (double)(nums1[l1]+nums2[l2])/2;
            }
            int mid = (l2+r2)/2;
            if((r2-l2)%2 == 0) {
                if(nums1[l1] < nums2[mid-1]) {
                    return (double)(nums2[mid]+nums2[mid-1])/2;
                }
                if(nums1[l1] > nums2[mid+1]) {
                    return (double)(nums2[mid]+nums2[mid+1])/2;
                }
                return (double)(nums1[l1]+nums2[mid])/2;
            }
            if(nums1[l1] < nums2[mid]) {
                return nums2[mid];
            }
            if(nums1[l1] > nums2[mid+1]) {
                return nums2[mid+1];
            }
            return nums1[l1];
        }
        int L1 = (l1+r1)/2;
        int R1 = (r1-l1)%2 == 0 ? L1 : L1+1;
        int L2 = (l2+r2)/2;
        int R2 = (r2-l2)%2 == 0 ? L2 : L2+1;
        if(nums1[L1] > nums2[R2]) {
            l2 += r1-L1;
            r1 = L1;
        } else if(nums1[R1] < nums2[L2]) {
            r2 -= R1-l1;
            l1 = R1;
        } else {
            return getMedianInFour(L1, R1, L2, R2);
        }
        return findMedianDoubleArrays(l1, r1, l2, r2);
    }

    public double getMedianInFour(int L1, int R1, int L2, int R2) {
        if(L1 == R1) {
            return nums1[L1];
        }
        if(L2 == R2) {
            return nums2[L2];
        }
        return (double)(Math.max(nums1[L1], nums2[L2])+Math.min(nums1[R1], nums2[R2]))/2;
    }

    public static void main(String[] args) {
        T4俩有序数组中位数 sol = new T4俩有序数组中位数();
        int[] nums1 = {4};
        int[] nums2 = {2,3};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));
    }
}

package 分治法.L169多数元素;

/**
 * 分治法
 */
public class Solution2 {
    public int majorityElement(int[] nums) {
        return majorityElementDC(nums, 0, nums.length-1)[0];
    }

    /**
     * 如果数 a 是数组 nums 的众数，如果我们将 nums 分成两部分，那么 a 必定是至少一部分的众数；
     * 将数组分成左右两部分，分别求出左半部分的众数 a1 以及右半部分的众数 a2，随后在 a1 和 a2 中选出正确的众数
     * @param nums
     * @param l
     * @param r
     * @return 该段的众数以及其相对数量（比非众数多的数）
     */
    public int[] majorityElementDC(int[] nums, int l, int r) {
        //一个数的众数为该数，相对数量为1
        if(l == r) {
            return new int[]{nums[l], 1};
        }
        int mid = (l+r)/2;
        int[] left = majorityElementDC(nums, l, mid);
        int[] right = majorityElementDC(nums, mid+1, r);
        //左右众数一样，则合并
        if(left[0] == right[0]) {
            return new int[]{left[0], left[1] + right[1]};
        }
        //不一样则众数为相对数较多的那个，并重新计算相对数量
        if(left[1] > right[1]) {
            return new int[]{left[0], left[1] - right[1]};
        }
        if(left[1] < right[1]) {
            return new int[]{right[0], right[1] - left[1]};
        }
        //相对数也一样则返回0（没有众数所以随意填）
        return new int[]{0, 0};
    }
}

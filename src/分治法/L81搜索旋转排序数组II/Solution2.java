package 分治法.L81搜索旋转排序数组II;

public class Solution2 {
    private boolean isMonotone = false;
    private boolean isEnd = false;
    
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        return search(l, r, nums, target);
    }

    public boolean search(int l, int r, int[] nums, int target) {
        if(isEnd) {
            return false;
        }
        if(l > r) {
            if(isMonotone) {//由于当前递归结果是确定单调区间后得到的，因此为最终情况，并列的递归可以直接终止
                isEnd = true;
            }
            return false;
        }
        int mid = (l + r) / 2;
        if (target == nums[mid]) {
            if(isMonotone) {//由于接下来返回了true，根据||的短路性质并列的部分不会再执行，isEnd = true可省略
                isEnd = true;
            }
            return true;
        }
        if(nums[mid] == nums[l] && nums[mid] == nums[r]) {//此时无法确定最大值与最小值的临界点在哪一侧，所以mid左右都需做遍历
            return search(l, mid-1, nums, target) || search(mid+1, r, nums, target);
        }
        isMonotone = true;//若递归中打破了mid、l、r三者相等的情况，即确定临界点所在区间，则专注于当前轮次之后，无需考虑||并列的情况（省时间）
        if (nums[mid] >= nums[l]) {//说明l到mid全部正序，mid到r可能先比mid大，再比r小
            if (target >= nums[l] && target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        } else {//mid到r全部正序，l到mid可能先比r大，后比mid小
            if (target <= nums[r] && target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return search(l, r, nums, target);
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int[] nums = {0,2,0,0,0,0,0,0,0};
        int target = 1;
        System.out.println(sol.search(nums, target));
    }
}

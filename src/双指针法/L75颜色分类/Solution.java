package 双指针法.L75颜色分类;

public class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        int cur = 0;
        //2优先级最高，遇到放到最右，然后再判断把0放到最左
        while (cur <= p2) {
            if (nums[cur] == 0) {//遇到0就交换cur与最左侧的1，移到下一个
                nums[cur] = nums[p0];
                nums[p0] = 0;
                p0++;
                cur++;
            } else if (nums[cur] == 1) {//遇到1cur就跳到下一个，记录最左侧的1指针不变
                cur++;
            } else {//遇到2就与最右侧的0或1交换，把2放到右侧，不移动cur指针（再判断是0还是1）
                nums[cur] = nums[p2];
                nums[p2] = 2;
                p2--;
            }
        }
    }
}

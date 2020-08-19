package 动态规划.L523连续的子数组和;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        list.add(0);
        for(int num : nums) {
            sum = k == 0 ? (sum+num) : ((sum+num) % k);//从开始到num的和对k取余，如果k为0余数为和本身
            if(list.contains(sum) && list.indexOf(sum) != list.size()-1) {//i和j余数相等则说明i+1到j数之和对k取余为0，要求i和j至少相差2
                return true;
            } else {
                list.add(sum);
            }
        }
        return false;
    }
}

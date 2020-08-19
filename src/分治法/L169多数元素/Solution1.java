package 分治法.L169多数元素;

/**
 * 投票法：将众数记为+1，其他数记为-1，则加起来总和大于0
 */
public class Solution1 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = 0;//不用设初值
        //不同数之间相互抵消，最坏情况非众数全都用来抵消众数，由于众数>非众数最后保留的也一定是众数
        for (int num : nums) {
            //当被选举数count=0时重新选举一个数（初始时count=0自动选举第一个数）
            if(count == 0) {
                res = num;
                count++;
            } else {
                //记录被选举数的相对数量
                if(num == res) {
                    count++;
                } else {
                    //当与被选举数不同时抵消掉一个
                    count--;
                }
            }
        }
        return res;
    }
}

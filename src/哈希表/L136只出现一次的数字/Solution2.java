package 哈希表.L136只出现一次的数字;

/**
 * 位运算，异或
 */
public class Solution2 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}

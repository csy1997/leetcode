package 其他.L137只出现一次的数字II;

/**
 * 位运算，异或、与、非
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
//            仅当 seen_twice 未变时，改变 seen_once
//            仅当 seen_once 未变时，改变seen_twice
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
//            System.out.println(Integer.toBinaryString(num) + " " + Integer.toBinaryString(seenOnce) + " " + Integer.toBinaryString(seenTwice));
        }

        return seenOnce;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4,4,1,4,3,2,2,3,3,2};
        sol.singleNumber(nums);
    }
}

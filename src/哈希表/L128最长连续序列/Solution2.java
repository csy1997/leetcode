package 哈希表.L128最长连续序列;

import 回溯算法与搜索.L79单词搜索.Solution;

import java.util.HashMap;

public class Solution2 {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();//记录数所在连续序列的长度
        int max = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int leftLength = map.getOrDefault(num - 1, 0);//num左边连续序列长度
                int rightLength = map.getOrDefault(num + 1, 0);//num右边连续序列长度
                int totalLength = leftLength + rightLength + 1;
                max = Math.max(max, totalLength);
                map.put(num, 0);//这里value不重要，当前数作为key放到map里即可，表示已遍历后面不再处理
                //将新序列长度记录到左右端的数对应的value里（中间数的value值后面不会用到所以不用全改）
                map.put(num - leftLength, totalLength);
                map.put(num + rightLength, totalLength);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        Solution2 sol = new Solution2();
        System.out.println(sol.longestConsecutive(nums));
    }
}

package 贪心法.L56合并区间;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(ints -> ints[0]));
        int left = intervals[0][0];
        int right = intervals[0][1];
        int j = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= right) {//right记录连续数组能到的最右端，如果当前i数组左端<right，则可以合并，更新right
                right = Math.max(right, intervals[i][1]);
            } else {//否则i之前为新的合并数组，记录到j，并用i更新新合并数组左右界
                intervals[j][0] = left;
                intervals[j][1] = right;
                j++;
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        intervals[j][0] = left;
        intervals[j][1] = right;//结束时也要合并一次
        return Arrays.copyOf(intervals, j + 1);//0到j长度为j+1
    }
}

package 数数组和字符串.L57插入区间;

import java.util.Arrays;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        int i;
        int j;
        for(i = 0; i < intervals.length; i++){//找到第一个需要合并的数组
            if(left <= intervals[i][1]){
                break;
            }
        }
        for(j = intervals.length-1; j >= 0; j--){//找到最后一个合并的数组
            if(right >= intervals[j][0]){
                break;
            }
        }
        if(j < i){
            return update(intervals, i, j, newInterval);
        }
        //左右边界还需要比较
        left = Math.min(left, intervals[i][0]);
        right = Math.max(right, intervals[j][1]);
        int[] res = new int[]{left, right};
        return update(intervals, i, j, res);
    }

    public int[][] update(int[][] intervals, int i, int j, int[] res) {
        if(i <= j) {//将第i到j个数组合并成一个数组
            intervals[i] = res;
            for (int k = j+1; k < intervals.length; k++) {
                intervals[k-j+i] = intervals[k];
            }
            return Arrays.copyOf(intervals, intervals.length-j+i);
        }
        //i比j还大，说明newInterval刚好在intervals缝隙，不需要合并，需增加进去
        int[][] arr = Arrays.copyOf(intervals, intervals.length+i-j);
        for (int k = arr.length-1; k > i; k--) {
            arr[k] = arr[k-i+j];
        }
        arr[i] = res;
        return arr;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,5}};
        int[] newInterval = {0,0};
        Solution sol = new Solution();
        System.out.println(Arrays.deepToString(sol.insert(intervals, newInterval)));
    }
}

package 贪心法.最优装载问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 状态规划的子问题
 * 装最多可以对重量从小到大排序，按轻者优先的贪心策略装；但装最少（装满，或者空隙没有物品可放）不能用重者优先，可证明
 */
public class Solution {
    /**
     * 贪心法正确：用数学归纳法和反证法可证明（替换为最小元素不改变最优解）
     * @param arr
     * @param W
     * @return
     */
    public List<Integer> getMaxCount(Integer[] arr, int W) {
        Arrays.sort(arr);
        int sum = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if((sum += arr[i]) > W) {
                break;
            }
            res.add(arr[i]);
        }
        return res;
    }

    /**
     * 找零钱问题
     * 贪心法错误：直接用反例证明
     * @param arr
     * @param W
     * @return
     */
    public List<Integer> getMinCount(Integer[] arr, int W) {
        Comparator<Integer> cmp = new Comparator<>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t2 - t1;
            }
        };
        Arrays.sort(arr, cmp);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(W >= arr[i]) {
                res.add(arr[i]);
                W -= arr[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Integer[] arr = {1,5,2,5,6,2};
        int W = 10;
        System.out.println(sol.getMaxCount(arr, W));//最多装载是1,2,2,5
        System.out.println(sol.getMinCount(arr, W));//最少装载是5,5，不一致
    }
}

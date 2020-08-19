package 分治法.L932漂亮数组;

import java.util.HashMap;

/**
 * 思路：分治法
 * 分析：
 * 1.A[k] * 2 != A[i] + A[j]， 左边一定是偶数，若让A[i]为奇数， A[j]为偶数则成立；
 * 2.可将1~N分成数量(N+1)/2的奇数和N/2的偶数两部分，并分别放在左右侧，此时如果让i在左侧j在右侧则等式恒成立；
 * 3.再考虑i，j同一侧的问题。有一个巧妙的性质：若{x1,x2,x3...}是漂亮的，则对其作线性变换{kx1+b,kx2+b,kx3+b...}也是漂亮的，
 *   因此考虑到2中左侧部分奇数可由1~(N+1)/2的连续数xi作2xi-1的变换获得，右侧部分偶数可由1~N/2的连续数xi作2xi（+0）的变换获得，
 *   因此若使得对应连续数满足条件，按照映射排列顺序就可以让1~N也满足；
 * 4.按照以上思路分治递归，终止条件为N=1时，结果为{1}满足要求。
 * 5.例如{1,2,3,4} -> {1,3},{2,4} -> 2{1,2}-1,2{1,2} -> 2({1},{2})-1,2({1},{2}) -> 2(2{1}-1,2{1})-1,2(2{1}-1,2{1}-1)，
 *   从右往左逆推得到{1,3,2,4}。
 */
public class Solution {
    /**
     * 递归时左右可能会到达同一个子数组，重复计算会降低效率
     * @param N
     * @return
     */
    public int[] beautifulArray1(int N) {
        if(N == 1) {
            return new int[]{1};
        }
        int[] res = new int[N];
        int i = 0;
        for(int x : beautifulArray1((N+1)/2)) {
            //左边由对(N+1)/2漂亮数组进行2x-1映射得到
            res[i++] = 2 * x - 1;
        }
        for(int x : beautifulArray1(N/2)) {
            //右边由对N/2漂亮数组进行2x映射得到
            res[i++] = 2 * x;
        }
        return res;
    }

    /**
     * 考虑到数组会重复计算，直接从1~N迭代顺推并记录中间的数组（dp)，但这样其中很多数组用不到，多余的计算也会降低效率
     * @param N
     * @return
     */
    public int[] beautifulArray2(int N) {
        int[][] dp = new int[N][N];
        dp[0][0] = 1;
        for(int i = 1; i < N; i++) {
            int j = 0;
            for(int k = 0; k <= i/2; k++) {
                dp[i][j++] = 2*dp[i/2][k]-1;
            }
            for(int k = 0; k <= (i-1)/2; k++) {
                dp[i][j++] = 2*dp[(i-1)/2][k];
            }
        }
        return dp[N-1];
    }

    private HashMap<Integer, int[]> map = new HashMap<>();
    /**
     * 在递归中用map记录已经计算出一次的N和对应的数组，避免重复计算
     * @param N
     * @return
     */
    public int[] beautifulArray3(int N) {
        //已经存在就直接拿出返回
        if(map.containsKey(N)) {
            return map.get(N);
        }
        int[] res = new int[N];
        if(N == 1) {
            res[0] = 1;
            map.put(N, res);
            return res;
        }
        int i = 0;
        for(int x : beautifulArray3((N+1)/2)) {
            //左边由对(N+1)/2漂亮数组进行2x-1映射得到
            res[i++] = 2 * x - 1;
        }
        for(int x : beautifulArray3(N/2)) {
            //右边由对N/2漂亮数组进行2x映射得到
            res[i++] = 2 * x;
        }
        map.put(N, res);
        return res;
    }
}

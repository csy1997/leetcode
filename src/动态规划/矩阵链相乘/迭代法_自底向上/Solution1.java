package 动态规划.矩阵链相乘.迭代法_自底向上;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    int[][] dp;//记录该段矩阵最小乘法计算，行是矩阵段长（初始为1），列是起始位置
    int[][] trace;//记录dp中每段的最佳分割位置（分割矩阵位置k，即第k-1与k矩阵之间），行是段长，列是起始位置，以便最终回溯轨迹

    /**
     * 返回dp最后一个值，即第0到dp.length-1个矩阵链最小乘法次数
     * @param P
     * @return
     */
    public int minMatrixMultis(int[] P) {
        dp = new int[P.length-1][P.length-1];
        trace = new int[P.length-2][P.length-2];//trace可以缩小空间，从段长为2开始记录，为1时单个矩阵不用分割
//        Arrays.fill(dp[0], 0);//第一行单个矩阵，恒为0
        for (int r = 1; r < dp.length; r++) {
            for (int i = 0; i+r < dp.length; i++) {
                int min = Integer.MAX_VALUE;
                int t = 0;
                for (int k = i+1; k <= i + r; k++) {
                    //下标i到i+r的矩阵从k-1和k矩阵之间分割，对应P分割位置为P[k]
                    int temp = P[i]*P[k]*P[i+r+1] + dp[k-i-1][i] + dp[i+r-k][k];
                    if(temp < min) {
                        min = temp;
                        t = k;
                    }
                }
                dp[r][i] = min;
                trace[r-1][i] = t;
            }
        }
        return dp[dp.length-1][0];
    }

    /**
     * 返回分割轨迹
     */
    public List<Integer> getTrace() {
        List<Integer> res = new ArrayList<>();
        getTrace(res, trace.length-1, 0);
        return res;
    }

    public void getTrace(List<Integer> res, int r, int i) {
        if(r <= 0) {//小于等于两个矩阵时明显不用分割
            return;
        }
        int sep = trace[r][i];
        res.add(sep);//确定分割位置并记录
        getTrace(res, sep-i-2, i);
        getTrace(res, r-sep+i, sep);
    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        int[] P = {30,35,15,5,10,20};
        System.out.println(sol.minMatrixMultis(P));
//        System.out.println(Arrays.deepToString(sol.dp));
//        System.out.println(Arrays.deepToString(sol.trace));
        System.out.println(sol.getTrace());
    }
}

package 动态规划.矩阵链相乘.递归法_自顶向下;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    int[][] dp;
    int[][] trace;//记录dp中每段的最佳分割位置（分割矩阵位置k，即第k-1与k矩阵之间），行是段长，列是起始位置，以便最终回溯轨迹

    public int minMatrixMultis(int[] P) {
        dp = new int[P.length-1][P.length-1];
        trace = new int[P.length-2][P.length-2];//trace可以缩小空间，从段长为2开始记录，为1时单个矩阵不用分割
        return minMatrixMultis(P, 0, P.length-1);
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

    /**
     * 求出i到j-1段矩阵相乘最小值
     * @param P
     * @param i
     * @param j
     * @return
     */
    public int minMatrixMultis(int[] P, int i, int j) {
        if(i == j-1) {//当i和j中间没有数即只剩一个矩阵时，无需计算返回0
            return 0;
        }
        //dp初始化为0，不为0则已被保存，已被保存的直接拿来用
        if(dp[i][j-1] != 0) {
            return dp[i][j-1];
        }
        int min = Integer.MAX_VALUE;//记录最小值
        int t = 0;//记录最合适分割位置
        for (int k = i+1; k < j; k++) {
            //遍历k即分割矩阵的位置
            int temp = P[i]*P[k]*P[j] + minMatrixMultis(P, i, k) + minMatrixMultis(P, k, j);
            if(temp < min) {
                min = temp;
                t = k;
            }
        }
        //第一次求得i到j的结果（即下标i到j-1的矩阵相乘最小次数）保存下来
        dp[i][j-1] = min;
        trace[j-i-2][i] = t;
        return min;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int[] P = {30,35,15,5,10,20};
        System.out.println(sol.minMatrixMultis(P));
//        System.out.println(Arrays.deepToString(sol.dp));
//        System.out.println(Arrays.deepToString(sol.trace));
        System.out.println(sol.getTrace());
    }
}

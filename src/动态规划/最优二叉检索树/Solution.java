package 动态规划.最优二叉检索树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    double[] P;
    double[][] sum;//各段即i到j元素概率之和，包括空隙和两边的
    double[][] dp;
    int[][] trace;//记录最优分割点

    public double getMinTime(double[] P) {
        this.P = P;
        this.sum = new double[P.length/2][P.length/2];
        this.dp = new double[P.length/2][P.length/2];
        this.trace = new int[P.length/2][P.length/2];
        //先把各段概率和算出来，dp直接调用
        for (int i = 0; i < sum.length; i++) {
            double temp = P[2*i];
            for (int j = i; j < sum.length; j++) {
                temp += P[2*j+1]+P[2*j+2];
                sum[i][j] = temp;
            }
        }
        //i等于j时，树只有一个节点，所有情况只需要比较一次，最小值就等于i概率和
        for (int i = 0; i < dp.length; i++) {
            dp[0][i] = sum[i][i];
            trace[0][i] = i;
        }

        for (int l = 1; l < dp.length; l++) {
            for (int i = 0; i+l < dp.length; i++) {
                //先计算两端k=i和k=j的，都只需要计算半边（另一边无节点），也等同于i到i-1的dp为0
                int minK = i;
                double min = dp[l-1][i+1];
                if(dp[l-1][i] < min) {
                    min = dp[l-1][i];
                    minK = i+l;
                }
                //i<k<j的情况
                for (int k = i+1; k <= i+l-1; k++) {
                    double temp = dp[k-i-1][i]+dp[i+l-k-1][k+1];
                    if(temp < min) {
                        min = temp;
                        minK = k;
                    }
                }
                dp[l][i] = min + sum[i][i+l];//dp方程：dp[i,j] = min(dp[i,k-1]+dp[k+1,j]+sum[i,j])
                trace[l][i] = minK;
            }
        }
        return dp[dp.length-1][0];
    }

    /**
     * 返回最优检索树层序遍历
     * @return
     */
    public List<Character> getOptimalSearchTree() {
        List<Character> res = new ArrayList<>();
        //用两个list记录段端点，做成队列遍历
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(0);
        list2.add(trace.length-1);
        while(list1.size() != 0) {
            int i = list1.get(0);
            int j = list2.get(0);
            if(i == j+1) {//i比j大，代表null
                res.add('*');
            } else {
                int k = trace[j-i][i];
                res.add((char)(k + 49));//+49为了将数组0开始变成实际1开始
                list1.add(i);
                list2.add(k-1);
                list1.add(k+1);
                list2.add(j);
            }
            list1.remove(0);
            list2.remove(0);
        }
        return res;
    }

//    public void getOptimalSearchTree(List<Integer> list, int i, int j) {
//        if(i == j+1) {
//            return;
//        }
//        int k = trace[j-i][i];
//        list.add(k);
//        getOptimalSearchTree(list, i, k-1);
//        getOptimalSearchTree(list, k+1, j);
//    }

    public static void main(String[] args) {
        double[] P = {0.04,0.1,0.01,0.2,0.05,0.2,0.02,0.1,0.02,0.1,0.07,0.05,0.04};
//        double[] P = {0.04,0.1,0.02,0.3,0.02,0.1,0.05,0.2,0.06,0.1,0.01};
        Solution sol = new Solution();
        System.out.println(sol.getMinTime(P));
//        System.out.println(Arrays.deepToString(sol.trace));
        System.out.println(sol.getOptimalSearchTree());
    }
}

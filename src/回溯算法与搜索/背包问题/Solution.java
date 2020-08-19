package 回溯算法与搜索.背包问题;

import java.util.Arrays;

public class Solution {
    int[] w;
    int[] v;
    double[] vPerw;
    int W;
    int V;
    int[] chosen;
    int maxV;
    int[] res;

    public int getMaxValueInBag(int[] w, int[] v, int W) {
        this.w = w;
        this.v = v;
        this.W = W;
        this.V = 0;
        this.chosen = new int[w.length];
        this.maxV = 0;
        this.res = new int[w.length];
        sortByVPerW();
        dfs(0);
        return maxV;
    }

    public void dfs(int i) {
        if(V + W * (i != w.length ? vPerw[i] : 0) <= maxV) {
            //代价函数意义：当前剩余的W全部用于装i（当i=w.length时单位价值设成0），得到的总V也不会比当前界maxV大，
            //所以后面单位价值更小的物品不用考虑
            return;
        }
        if(i == w.length) {
            maxV = V;
            res = chosen.clone();
            return;
        }
        int n = W / w[i];
        W -= (n+1)*w[i];
        V += (n+1)*v[i];
        for (; n >= 0; n--) {//从对i选最多到选少遍历（排前面的选多一些得到最优解可能性较大，方便剪枝）
            chosen[i] = n;
            W += w[i];
            V -= v[i];
            dfs(i+1);
        }
        //循环结束后W、V、chosen都会变回n=0时（不加物品i）的值，相当于回溯了
    }

    /**
     * 把物品按单位价值从大到小排序
     */
    public void sortByVPerW() {
        vPerw = new double[w.length];
        for (int i = 0; i < vPerw.length; i++) {
            vPerw[i] = (double) v[i]/w[i];
        }
        quickSort(0, vPerw.length-1);
    }

    public void quickSort(int l, int r) {
        if(l == r+1) {
            return;
        }
        double midNum = vPerw[r];
        int p = l;
        for (int i = l; i <= r; i++) {
            if(vPerw[i] >= midNum) {
                swap(p, i);
                p++;
            }
        }
        quickSort(l, p-2);
        quickSort(p, r);
    }

    private void swap(int i, int j) {
        if (i == j) {
            return;
        }
        int temp = w[i];
        w[i] = w[j];
        w[j] = temp;
        temp = v[i];
        v[i] = v[j];
        v[j] = temp;
        double temp1 = vPerw[i];
        vPerw[i] = vPerw[j];
        vPerw[j] = temp1;
    }

    public static void main(String[] args) {
        int[] w = {2,3,4,7};
        int[] v = {1,3,5,9};
        Solution sol = new Solution();
        System.out.println(sol.getMaxValueInBag(w, v, 20));
        System.out.println(Arrays.toString(sol.res));
    }
}

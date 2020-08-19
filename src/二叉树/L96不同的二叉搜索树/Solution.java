package 二叉树.L96不同的二叉搜索树;

/**
 * 卡特兰数
 */
public class Solution {
    public int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int i = 1; i <= n; i++) {
            int j;
            for (j = 1; j <= i / 2; j++) {//对称性遍历一半即可
                res[i] += res[j - 1] * res[i - j];
            }
            res[i] *= 2;
            if (i % 2 == 1) {
                res[i] += res[j - 1] * res[j - 1];
            }
        }
        return res[n];
    }
}

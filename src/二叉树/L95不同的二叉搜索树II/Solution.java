package 二叉树.L95不同的二叉搜索树II;

import 数据结构类.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<TreeNode>[][] dp;

    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new ArrayList<>();
        }
        this.dp = new List[n][n];
        return generateTrees(1, n);
    }

    /**
     * 不用完全克隆，用dp存储每段对应的二叉树的根节点集（dp数组不同位置对应的根节点引用不会相同，非根节点有可能相同），
     * 最终的各个树不完全独立（共用了非根节点，类似网状），但从各个根节点出发都只能得到唯一的一棵二叉树
     * @param l
     * @param r
     * @return
     */
    public List<TreeNode> generateTrees(int l, int r) {
        if(l == r+1) {
            return new ArrayList<>() {
                {
                    add(null);
                }
            };
        }
        if(dp[l-1][r-1] == null) {
            dp[l-1][r-1] = new ArrayList<>();
            for (int i = l; i <= r; i++) {
                for (TreeNode left : generateTrees(l, i - 1)) {
                    for (TreeNode right : generateTrees(i + 1, r)) {
                        dp[l-1][r-1].add(new TreeNode(i, left, right));
                    }
                }
            }
        }
        return dp[l-1][r-1];
    }
}

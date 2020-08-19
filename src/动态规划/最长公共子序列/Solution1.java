package 动态规划.最长公共子序列;

/**
 * 迭代法
 */
public class Solution1 {
    final int UP = 1;
    final int LEFT = 2;
    final int UPLEFT = 3;
    String X;
    String Y;
    int[][] dp;
    int[][] tag;

    public int getMaxCommonSubsequence(String X, String Y) {
        this.X = X;
        this.Y = Y;
        dp = new int[X.length()+1][Y.length()+1];
        tag = new int[X.length()][Y.length()];
        //第一列Y为空，公共长度为0
//        for (int i = 0; i < dp.length; i++) {
//            dp[i][0] = 0;
//        }
        //第一行X为空，公共长度为0
//        for (int i = 0; i < dp[0].length; i++) {
//            dp[0][i] = 0;
//        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;//当前X和Y对应字符相等，则当前字符可作为公共部分，公共子序列长度为各自的前一段+1（选了肯定不会比不选小）
                    tag[i-1][j-1] = UPLEFT;
                } else {
                    //对应字符不等，则公共长度为双方各自去掉当前字符的子序列较大者
                    if(dp[i-1][j] > dp[i][j-1]) {
                        dp[i][j] = dp[i-1][j];
                        tag[i-1][j-1] = UP;
                    } else {
                        dp[i][j] = dp[i][j-1];
                        tag[i-1][j-1] = LEFT;
                    }
                }
            }
        }
        return dp[X.length()][Y.length()];
    }

    public String getTrace() {
        StringBuilder sb = new StringBuilder();
        for (int i = tag.length-1, j = tag[0].length-1; i >= 0 && j >= 0; ) {
            if(tag[i][j] == UPLEFT) {
                sb.append(X.charAt(i));
                i--;
                j--;
            } else if(tag[i][j] == LEFT) {
                j--;
            } else if(tag[i][j] == UP) {
                i--;
            }
        }
        return sb.reverse().toString();
    }
}

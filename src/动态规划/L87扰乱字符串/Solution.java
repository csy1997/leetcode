package 动态规划.L87扰乱字符串;

public class Solution {
    private String s1;
    private String s2;
    //备忘dp，记录s1子串能否转换等长扰乱后的s2子串；0代表没判断，1代表true，-1代表false；
    //一维对应子串长度，s1和s2应当相等因此只占一维；二维三维分别为s1和s2子串的初始位置
    private int[][][] dp;

    public boolean isScramble(String s1, String s2) {
        int length = s1.length();
        if(length == 0) {
            return true;
        }
        this.s1 = s1;
        this.s2 = s2;
        this.dp = new int[length-1][length][length];//第一行为len=2的情况
        return isScramble(0, 0, length);
    }

    public boolean isScramble(int l1, int l2, int len) {//自顶向下递归，dp对应位置第一次判断后记录一下，后面遇到直接用
        if(len == 1) {//len=1可直接根据字符是否相等判断
            return s1.charAt(l1) == s2.charAt(l2);
        }
        if(dp[len-2][l1][l2] == 1) {
            return true;
        }
        if(dp[len-2][l1][l2] == -1) {
            return false;
        }
        for (int i = 1; i < len; i++) {//从左到右对s1当前子串进行分割，分割后新左右子串长度都不能小于1
            //用s1左子串对应s2等长左子串，右子串对应右子串，看能否都转换成功
            if(isScramble(l1, l2, i) && isScramble(l1+i, l2+i, len-i)) {
                dp[len-2][l1][l2] = 1;
                return true;
            }
            //用s1左子串对应s2等长右子串，右子串对应左子串，看能否都转换成功
            if(isScramble(l1, l2+len-i, i) && isScramble(l1+i, l2, len-i)) {
                dp[len-2][l1][l2] = 1;
                return true;
            }
        }
        dp[len-2][l1][l2] = -1;
        return false;
    }
}

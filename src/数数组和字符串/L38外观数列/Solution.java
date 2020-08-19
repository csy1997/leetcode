package 数数组和字符串.L38外观数列;

public class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            int len = 1;
            StringBuilder sum = new StringBuilder();
            for (int j = 0; j < res.length(); j++) {
                if (j == res.length() - 1 || res.charAt(j) != res.charAt(j + 1)) {//连续相同数字终止的时候可以记录该段对应的结果
                    sum.append(len);//该段长度
                    sum.append(res.charAt(j));//该段字符
                    len = 1;
                } else {
                    len++;
                }
            }
            res = sum.toString();
        }
        return res;
    }
}

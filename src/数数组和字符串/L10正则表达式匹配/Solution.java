package 数数组和字符串.L10正则表达式匹配;

public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
        dp[0][0] = true;
        int i;
        int _i = 1;
        for(i = 1; _i <= p.length(); i++){
            if(_i < p.length() && p.charAt(_i) == 42){
                int j = 0;
                while(j < dp[0].length){
                    if(dp[i-1][j]){
                        dp[i][j] = true;
                        int k;
                        for(k = j+1; k < dp[0].length; k++){
                            if(p.charAt(_i-1) == 46 || s.charAt(k-1) == p.charAt(_i-1)){
                                dp[i][k] = true;
                            }else{
                                break;
                            }
                        }
                        j = k;
                    }else{
                        j++;
                    }
                }
                _i += 2;
            }else{
                // dp[i][0] = false;
                for(int j = 1; j < dp[0].length; j++){
                    if(dp[i-1][j-1] && (p.charAt(_i-1) == 46 || s.charAt(j-1) == p.charAt(_i-1))){
                        dp[i][j] = true;
                    }
                }
                _i++;
            }
        }
        return dp[i-1][s.length()];
    }
}

package 数数组和字符串.L8字符串转换整数;

public class Solution {
    public int myAtoi(String str) {
        int sig = 1;
        int i;
        for(i = 0; i < str.length() && str.charAt(i) == 32; i++){

        }
        if(i == str.length()){
            return 0;
        }
        if(str.charAt(i) == 43){
            i++;
        }else if(str.charAt(i) == 45){
            sig = -1;
            i++;
        }else if(str.charAt(i) < 48 || str.charAt(i) > 57){
            return 0;
        }
        while(i < str.length() && str.charAt(i) == 48){
            i++;
        }
        int j;
        for(j = i; j < str.length(); j++){
            if(str.charAt(j) < 48 || str.charAt(j) > 57){
                break;
            }
        }
        String substr = str.substring(i, j);
        long res;
        if(substr.length() == 0){
            return 0;
        }
        if(substr.length() > 10){
            return sig == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }else{
            res = sig * Long.parseLong(substr);
            if(res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }else if(res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int)res;
    }
}

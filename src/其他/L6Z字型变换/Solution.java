package 其他.L6Z字型变换;

public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length() <= numRows) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int cycle = 2*numRows-2;//"Z"字每cycle一循环
        for(int r = 0; r < s.length(); r += cycle){//第一行
            sb.append(s.charAt(r));
        }
        for(int i = 1; i < cycle/2; i++){//2到倒2行
            int r = i;
            int e = cycle-r;
            //r和e相邻在一行
            while(e < s.length()){
                sb.append(s.charAt(r));
                sb.append(s.charAt(e));
                r += cycle;
                e += cycle;
            }
            if(r < s.length()) {//可能最后e比r多一个
                sb.append(s.charAt(r));
            }
        }
        for(int r = cycle/2; r < s.length(); r += cycle){//最后一行
            sb.append(s.charAt(r));
        }
        return sb.toString();
    }
}

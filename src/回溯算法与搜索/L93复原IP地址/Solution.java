package 回溯算法与搜索.L93复原IP地址;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        addToList(res, s, "", 4, 0);
        return res;
    }

    public void addToList(List<String> res, String s, String sub, int count, int i) {
        if(count == 0) {
            res.add(sub.substring(0, sub.length()-1));//结尾多加了一个"."，去掉
            return;
        }
        count--;
        int left = Math.max(s.length() - 3*count, i+1);//当前所截子串长度不小于1，也不能小到使剩下总长度大于后面子串都取最长3的长度和
        int right = Math.min(i+3, s.length() - count);//当前所截子串长度不小于3，也不能大到使剩下总长度小于后面子串都取最短1的长度和
        for (int j = left; j <= right; j++) {
            if(s.charAt(i) == '0' && j != i+1) {//子串除"0"外第一位不能为'0'
                return;
            }
            if(j == i+3 && Integer.parseInt(s.substring(i, j)) > 255) {//子串长度为3时对应值不能大于255
                return;
            }
            addToList(res, s, sub+s.substring(i, j)+".", count, j);
//            StringBuilder temp = new StringBuilder(sub).append(s, i, j).append(".");
//            addToList(res, s, temp.toString(), count, j);
        }
    }
}

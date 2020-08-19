package 贪心法.L12整数转罗马数字;

import java.util.HashMap;

public class Solution {
    public String intToRoman(int num) {
        int[] arr = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        HashMap<Integer, String> map = new HashMap<>() {
            {
                put(1000, "M");
                put(900, "CM");
                put(500, "D");
                put(400, "CD");
                put(100, "C");
                put(90, "XC");
                put(50, "L");
                put(40, "XL");
                put(10, "X");
                put(9, "IX");
                put(5, "V");
                put(4, "IV");
                put(1, "I");
            }
        };
        StringBuilder res = new StringBuilder();
        for(int a : arr) {//先选大数对应的字符，装不下了再继续选之后的小数，与4相关的数比较特殊需要单独放到map里
            while(num >= a) {
                res.append(map.get(a));
                num -= a;
            }
        }
        return res.toString();
    }
}

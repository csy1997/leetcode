package 哈希表.L13罗马数字转整数;

import java.util.HashMap;

public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int x = map.get(s.charAt(i));
            if(i != s.length()-1 && x < map.get(s.charAt(i+1))) {
                res -= x;
            } else {
                res += x;
            }
        }
        return res;
    }
}

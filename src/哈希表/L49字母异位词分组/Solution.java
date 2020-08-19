package 哈希表.L49字母异位词分组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) {
            return new ArrayList<>();
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String key = String.valueOf(s);//将字符串转成char数组排序，再组成新的字符串
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);//对应新字符串相同的放到一起
        }
        return new ArrayList<>(map.values());
    }
}

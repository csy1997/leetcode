package 回溯算法与搜索.L17电话号码的字母组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    List<String> res;
    String digits;
    StringBuilder sb;
    HashMap<Character, List<Character>> map;

    public Solution() {
        this.res = new ArrayList<>();
        this.sb = new StringBuilder();
        this.map = new HashMap<>();
        this.map.put('2', Arrays.asList('a', 'b', 'c'));
        this.map.put('3', Arrays.asList('d', 'e', 'f'));
        this.map.put('4', Arrays.asList('g', 'h', 'i'));
        this.map.put('5', Arrays.asList('j', 'k', 'l'));
        this.map.put('6', Arrays.asList('m', 'n', 'o'));
        this.map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        this.map.put('8', Arrays.asList('t', 'u', 'v'));
        this.map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        if(digits.length() == 0){
            return res;
        }
        addToList(0);
        return res;
    }

    public void addToList(int i){
        if(i == digits.length()){
            res.add(sb.toString());
            return;
        }
        for(char c : map.get(digits.charAt(i))){
            sb.append(c);
            addToList(i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

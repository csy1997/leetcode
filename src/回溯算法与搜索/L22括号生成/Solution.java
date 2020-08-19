package 回溯算法与搜索.L22括号生成;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max) {//保证任意时刻close不会大于open，open不大于max就行
        if (close == max) {
            ans.add(cur);
            return;
        }
        //String和int每次作为新参数，相当于不用回溯
        if (open < max) {
            backtrack(ans, cur + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(ans, cur + ")", open, close + 1, max);
        }
    }
}

package 回溯算法与搜索.L39组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);

        findList(candidates, res, list, 0, target);
        return res;
    }

    public void findList(int[] candidates, List<List<Integer>> res, List<Integer> list, int i, int target) {
        for (; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;//i不合适，后面的更大更不合适
            }
            if (target == candidates[i]) {
                list.add(candidates[i]);
                res.add((List<Integer>) ((ArrayList) list).clone());
                list.remove(list.size() - 1);
                return;//i刚好合适，后面的变大会超范围
            }
            list.add(candidates[i]);
            findList(candidates, res, list, i, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}

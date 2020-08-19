package 回溯算法与搜索.L40组合总和II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        for (int j = i; j < candidates.length; j++) {
            if (target < candidates[j]) {
                return;
            }
            if (target == candidates[j]) {
                list.add(candidates[j]);
                res.add((List) ((ArrayList) list).clone());
                list.remove(list.size() - 1);
                return;
            }
            if (j > i && candidates[j] == candidates[j - 1]) {//去重，每轮里连续相等的只选第一个，选后面的情况会被覆盖
                continue;
            }
            list.add(candidates[j]);
            findList(candidates, res, list, j + 1, target - candidates[j]);
            list.remove(list.size() - 1);
        }
    }
}

package 回溯算法与搜索.L78子集;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        addToList(res, list, 0, nums);
        return res;
    }

    public void addToList(List<List<Integer>> res, List<Integer> list, int i, int[] nums) {
        res.add((List) ((ArrayList) list).clone());
        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            addToList(res, list, j + 1, nums);
            list.remove(list.size() - 1);
        }
    }
}

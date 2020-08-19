package 回溯算法与搜索.L90子集II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        addToList(res, list, 0, nums);
        return res;
    }

    public void addToList(List<List<Integer>> res, List<Integer> list, int i, int[] nums) {
        res.add((List) ((ArrayList) list).clone());
        for (int j = i; j < nums.length; j++) {
            if (j == i || nums[j] != nums[j - 1]) {
                list.add(nums[j]);
                addToList(res, list, j + 1, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}

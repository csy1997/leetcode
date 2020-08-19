package 回溯算法与搜索.L46全排列;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> list = new ArrayList<>();
    int l;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        for (int n : nums) {
            list.add(n);
        }
        l = list.size();
        addToList(0);
        return res;
    }

    public void addToList(int i) {
        if (i == l - 1) {
            res.add((List) ((ArrayList) list).clone());
            return;
        }
        for (int j = i; j < l; j++) {
            swap(j, i);
            addToList(i + 1);
            swap(j, i);
        }
    }

    public void swap(int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}

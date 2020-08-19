package 回溯算法与搜索.L47全排列II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    List<Integer> list = new ArrayList<>();
    int l;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        for (int n : nums) {
            list.add(n);
        }
        l = list.size();
//        Arrays.sort(nums);//有set记录，不用排序去重
        addToList(0);
        return res;
    }

    public void addToList(int beg) {
        if (beg == l - 1) {
            res.add((List) ((ArrayList) list).clone());
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = beg; i < l; i++) {
            if (!set.contains(list.get(i))) {//去重，循环中选过的数不再选
                set.add(list.get(i));
                swap(i, beg);
                addToList(beg + 1);
                swap(i, beg);
            }
        }
    }

    public void swap(int i, int j) {
        if(i == j) {
            return;
        }
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}

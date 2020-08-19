package 回溯算法与搜索.L77组合;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        addToList(res, list, 1, n, k);
        return res;
    }

    public void addToList(List<List<Integer>> res, List<Integer> list, int i, int n, int k) {
        if (k == 0) {
            res.add((List) ((ArrayList) list).clone());
            return;
        }
        for (int j = i; j <= n - k + 1; j++) {//还需要k-1个数，当j等于n-k+1时还剩k-1个数
            list.add(j);
            addToList(res, list, j + 1, n, k - 1);
            list.remove(list.size() - 1);
        }
    }
}

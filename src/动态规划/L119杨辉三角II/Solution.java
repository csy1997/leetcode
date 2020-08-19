package 动态规划.L119杨辉三角II;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = res.size()-1; j >= 1; j--) {//原地更新
                res.set(j, res.get(j-1) + res.get(j));
            }
            res.add(1);
        }
        return res;
    }
}

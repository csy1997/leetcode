package 动态规划.L118杨辉三角;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) {
            return res;
        }
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        res.add(nums);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 0; j < nums.size() - 1; j++) {
                temp.add(nums.get(j) + nums.get(j+1));
            }
            temp.add(1);
            nums = temp;
            res.add(nums);
        }
        return res;
    }
}

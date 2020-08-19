package 回溯算法与搜索.L60第k个排列;

import java.util.ArrayList;

public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {//按字典序排好n个数
            list.add(i);
        }
        int[] fields = new int[n - 1];
        int accumulate = 1;
        for (int i = fields.length-1; i >= 0; i--) {//n个数有n!个排列，或者说n*(n-1)!
            fields[i] = accumulate;
            accumulate *= n-i;
        }
        if(k > accumulate) {//k比n!还大，说明超出范围
            return null;
        }
        --k;
        StringBuilder sb = new StringBuilder();
        for (int field : fields) {
            int digit = k / field;
            sb.append(list.get(digit));
            list.remove(digit);
            k %= field;
        }
        sb.append(list.get(0));
        return sb.toString();
    }
}

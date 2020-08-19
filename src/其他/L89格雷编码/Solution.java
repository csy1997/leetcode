package 其他.L89格雷编码;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 原理：
     * 0
     * 0 1 (1 0)
     * 00 01 11 10 (10 11 01 00)
     * 000 001 011 010 110 111 101 100
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            //迭代镜像翻转，即复制本轮中list所有元素并倒序处理，并对二进制形态下每个复制的元素前面加一位'1'，合并到原list末尾
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));//加上head相当于对应二进制形态最左边加一位'1'
            }
            head *= 2;
        }
        return res;
    }
}

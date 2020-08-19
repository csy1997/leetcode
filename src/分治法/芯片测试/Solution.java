package 分治法.芯片测试;

import 分治法.芯片测试.chip.Chip;

import java.util.List;


public class Solution {
    /**
     * 蛮力解法 o(n^2)
     * @param chips
     * @return
     */
    public Chip getOneGoodChip(List<Chip> chips) {
        for (int i = 0; i < chips.size(); i++) {
            if(judgeOneInChips(i, chips)) {
                return chips.get(i);
            }
        }
        return null;
    }

    /**
     * 用其他芯片判断某一芯片
     * @param i
     * @param chips
     * @return
     */
    public boolean judgeOneInChips(int i, List<Chip> chips) {
        int res = 0;
        for (int j = 0; j < chips.size(); j++) {
            if(j != i && chips.get(j).judge(chips.get(i))) {
                res++;
            }
        }
        // 只要超过（包括）一半的其他芯片将该芯片判为好芯片，则必定为好芯片
        return res >= chips.size()/2;
    }
}

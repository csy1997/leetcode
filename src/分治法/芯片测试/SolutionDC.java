package 分治法.芯片测试;

import 分治法.芯片测试.chip.Chip;

import java.util.ArrayList;
import java.util.List;

/**
 * 分治解法
 * 基本思想：
 * 1.每次将芯片两两分为一组。若奇数轮多余出一个，则对多出的单独测试（即用其他所有芯片对其测试），若为坏芯片则丢弃转为偶数轮，好芯片则结束；
 * 2.每组进行互相测试，只保留测试结果都为好芯片的组（可证明只可能是"好好"或者"坏坏"）；
 *   其他情况丢弃（只可能是一好一坏和俩坏），丢弃的的坏>=好；
 * 3.由于保留的芯片里仍然好>坏，从保留的每组任取一个进入下一轮（好，坏各取一半，好>坏）；
 * 4.递归，当总数<=2时，返回一个芯片结束。
 */
public class SolutionDC {
    /**
     * 分治解法 o(n)
     * @param chips
     * @return
     */
    public Chip getOneGoodChip(List<Chip> chips) {
        if(chips.size() <= 2) {
            return chips.get(0);
        }
        int i = 0;
        if(chips.size() % 2 == 1) {
            if(judgeOneInChips(0, chips)) {
                return chips.get(i);
            }
            i++;
        }
        List<Chip> temp = new ArrayList<>();
        for (; i < chips.size(); i+=2) {
            Chip c1 = chips.get(i);
            Chip c2 = chips.get(i+1);
            // 两两测试
            if(c1.judge(c2) && c2.judge(c1)) {
                temp.add(c1);
            }
        }
        return getOneGoodChip(temp);
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
            if (j != i && chips.get(j).judge(chips.get(i))) {
                res++;
            }
        }
        // 只要超过（包括）一半的其他芯片将该芯片判为好芯片，则必定为好芯片
        return res >= chips.size() / 2;
    }
}

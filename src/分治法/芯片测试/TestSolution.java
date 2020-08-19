package 分治法.芯片测试;

import 分治法.芯片测试.chip.Chip;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSolution {
    private List<Chip> chips;

    @Before
    public void initChips() {
        chips = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            chips.add(new Chip(true));
        }
        for (int i = 0; i < 3; i++) {
            chips.add(new Chip(false));
        }
        Collections.shuffle(chips);
    }

    @Test
    public void testSolution() {
        Solution sol = new Solution();
        Chip chip = sol.getOneGoodChip(chips);
//        for (int i = 0; i < chips.size(); i++) {
//            if(chip == chips.get(i)) {
//                System.out.println(i);
//                break;
//            }
//        }
        chip.showTag();
    }

    @Test
    public void testSolutionDC() {
        SolutionDC sol = new SolutionDC();
        Chip chip = sol.getOneGoodChip(chips);
//        for (int i = 0; i < chips.size(); i++) {
//            if(chip == chips.get(i)) {
//                System.out.println(i);
//                break;
//            }
//        }
        chip.showTag();
    }
}

package 分治法.芯片测试.chip;

import java.util.Random;

public class Chip {
    private boolean tag;

    public Chip(boolean tag) {
        this.tag = tag;
    }

    public boolean judge(Chip chip) {
        if(this.tag) {
            return chip.getTag();
        } else {
            return new Random().nextBoolean();
        }
    }

    private boolean getTag() {
        return tag;
    }

    public void showTag() {
        System.out.println(tag);
    }
}

package 数数组和字符串.L68文本左右对齐;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }
        int beg = 0;
        int len = 0;
        for (int i = 0; i < words.length; i++) {
            int temp = len + words[i].length();
            if (temp + i - beg > maxWidth) {
                if (i == beg + 1) {
                    StringBuilder sb = new StringBuilder(words[beg++]);
                    for (int j = 0; j < maxWidth - len; j++) {
                        sb.append(' ');
                    }
                    res.add(sb.toString());
                } else {
                    int gapAvg = (maxWidth - len) / (i - beg - 1);
                    int gapRem = (maxWidth - len) % (i - beg - 1);
                    StringBuilder sb = new StringBuilder(words[beg++]);
                    for (; gapRem > 0 && beg < i; beg++) {
                        for (int k = 0; k <= gapAvg; k++) {
                            sb.append(' ');
                        }
                        sb.append(words[beg]);
                        gapRem--;
                    }
                    for (; beg < i; beg++) {
                        for (int k = 0; k < gapAvg; k++) {
                            sb.append(' ');
                        }
                        sb.append(words[beg]);
                    }
                    res.add(sb.toString());
                }
                len = words[i].length();
            } else {
                len = temp;
            }
        }
        StringBuilder sb = new StringBuilder(words[beg++]);
        int temp = words.length - beg;
        for (; beg < words.length; beg++) {
            sb.append(' ');
            sb.append(words[beg]);
        }
        for (int k = 0; k < maxWidth - len - temp; k++) {
            sb.append(' ');
        }
        res.add(sb.toString());
        return res;
    }
}

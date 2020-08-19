package 数数组和字符串.L68文本左右对齐;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }
        int len = words[0].length();//left到right单词总长
        int left = 0;
        int right = 1;
        while (right < words.length) {
            int lenWithGap = len + words[right].length() + right - left;//left到right两两单词加上单位1空隙的总长度
            if (lenWithGap > maxWidth) {//大于maxWidth，将left到right（不包括right）单词合并为一行
                addRow(words, maxWidth, res, left, right, len);
                left = right;
                len = words[left].length();
            } else {
                len += words[right].length();
            }
            right++;
        }
        addRow(words, maxWidth, res, left, right, len);//最后一行还要合并一次
        return res;
    }

    private void addRow(String[] words, int maxWidth, List<String> res, int left, int right, int len) {
        int gaps = maxWidth - len;//空隙总长
        StringBuilder sb = new StringBuilder(words[left++]);//先把第一个单词加进去
        if (left == right) {//只有一个单词情况
            sb.append(" ".repeat(maxWidth - len));
        } else if (right == words.length) {//最后一行情况
            while (left < right) {
                sb.append(" ");
                sb.append(words[left]);
                left++;
                gaps--;
            }
            sb.append(" ".repeat(gaps));
        } else {
            int n = right - left;//空隙数比单词数少1
            int gapAvg = gaps / n;//平均长度空隙
            int gapRem = gaps % n;//平均分配后余下的空隙
            while (left < right) {
                if (gapRem != 0) {
                    sb.append(" ".repeat(gapAvg + 1));//靠左分配平均长度多一个
                    gapRem--;
                } else {
                    sb.append(" ".repeat(gapAvg));
                }
                sb.append(words[left]);
                left++;
            }
        }
        res.add(sb.toString());
    }
}

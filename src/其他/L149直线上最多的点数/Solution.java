package 其他.L149直线上最多的点数;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maxPoints(int[][] points) {
        int l = points.length;
        if (l < 3) {
            return l;
        }
        boolean[][] isChosenLine = new boolean[l][l];//记录已考察过的直线
        int max = 2;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if (!isChosenLine[i][j]) {
                    isChosenLine[i][j] = true;
                    int[] p1 = points[i];
                    int[] p2 = points[j];
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    for (int k = 0; k < l; k++) {
                        if (k != i && k != j && isCollinear(p1, p2, points[k])) {
                            for (int p : list) {
                                isChosenLine[p][k] = true;//将共线的点连接的直线全设为已考察
                            }
                            if (isSamePoint(p1, p2)) {//直线的两顶点如果相等，就把共线新点设为新顶点，避免新顶点之间不共线的情况
                                p2 = points[k];
                            }
                            list.add(k);
                        }
                    }
                    max = Math.max(max, list.size());
                }
            }
        }
        return max;
    }

    public boolean isSamePoint(int[] p1, int[] p2) {
        return p1[0] == p2[0] && p1[1] == p2[1];
    }

    public boolean isCollinear(int[] p1, int[] p2, int[] p) {
        if (isSamePoint(p1, p2) || isSamePoint(p1, p) || isSamePoint(p2, p)) {
            return true;
        }
        long x = (long) (p[0] - p1[0]) * (p1[1] - p2[1]);
        long y = (long) (p[1] - p1[1]) * (p1[0] - p2[0]);
        return x == y;
    }
}

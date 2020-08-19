package 其他.L149直线上最多的点数;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public int maxPoints(int[][] points) {
        int l = points.length;
        if (l < 3) {
            return l;
        }
        int max = 2;
        int[] pointAmount = new int[l];//提前去重并记录相同点的数量，下标对应points中的点，除第一个后面相同的点设为-1代表不用遍历
        for (int i = 0; i < l; i++) {
            if (pointAmount[i] != -1) {
                pointAmount[i] = 1;
                for (int j = i+1; j < l; j++) {
                    if (pointAmount[j] != -1 && isSamePoint(points[i], points[j])) {
                        pointAmount[i]++;
                        pointAmount[j] = -1;
                    }
                }
                max = Math.max(max, pointAmount[i]);
            }
        }
        boolean[][] isChosenLine = new boolean[l][l];//记录已考察过的直线
        for (int i = 0; i < l; i++) {
            if (pointAmount[i] == -1) {
                continue;
            }
            for (int j = i + 1; j < l; j++) {
                if (pointAmount[j] == -1) {
                    continue;
                }
                if (!isChosenLine[i][j]) {
                    int count = pointAmount[i] + pointAmount[j];
                    isChosenLine[i][j] = true;
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    for (int k = 0; k < l; k++) {
                        if (k != i && k != j && pointAmount[k] != -1 && isCollinear(points[i], points[j], points[k])) {
                            count += pointAmount[k];
                            for (int p : list) {
                                isChosenLine[p][k] = true;//将共线的点连接的直线全设为已考察
                            }
                            list.add(k);
                        }
                    }
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }

    public boolean isSamePoint(int[] p1, int[] p2) {
        return p1[0] == p2[0] && p1[1] == p2[1];
    }

    public boolean isCollinear(int[] p1, int[] p2, int[] p) {
        long x = (long) (p[0] - p1[0]) * (p1[1] - p2[1]);
        long y = (long) (p[1] - p1[1]) * (p1[0] - p2[0]);
        return x == y;
    }
}

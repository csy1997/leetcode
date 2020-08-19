package 贪心法.最小生成树.Prim算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 时间复杂度o(n^2)；
 * 证明方法：数学归纳，假设最优，由于生成树加边会形成回路，加连接的最短边，去另一条边，仍然最优；
 *
 */
public class Solution {
    public List<int[]> getMinSpanningTree(int[][] graph) {
        List<int[]> res = new ArrayList<>();
        List<Integer> S = new ArrayList<>();
        List<Integer> V = new ArrayList<>();
        S.add(0);
        for (int i = 1; i < graph.length; i++) {
            V.add(i);
        }
        while(V.size() != 0) {
            int x = -1;
            int y = -1;
            int min = Integer.MAX_VALUE;
            for(int s : S) {
                for(int v : V) {
                    int temp = graph[s][v];
                    if(temp != -1 && temp < min) {
                        min = temp;
                        x = s;
                        y = v;
                    }
                }
            }
            res.add(new int[]{x, y});
            S.add(y);
            V.remove(Integer.valueOf(y));
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0,6,1,5,-1,-1},
                {6,0,5,-1,3,-1},
                {1,5,0,5,6,4},
                {5,-1,5,0,-1,2},
                {-1,3,6,-1,0,6},
                {-1,-1,4,2,6,0}
        };
        Solution sol = new Solution();
        List<int[]> res = sol.getMinSpanningTree(graph);
        for(int[] r :res) {
            System.out.println(Arrays.toString(r));
        }
    }
}

package 贪心法.最短路径Dijkstra算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 时间复杂度o(nm)，n点m边
 * 证明：数学归纳
 */
public class Solution {
    public int[] getMinPaths(int[][] graph) {
        int[] dist = new int[graph.length];
        List<Integer> S = new ArrayList<>();
        List<Integer> V = new ArrayList<>();
        dist[0] = 0;
        for (int i = 1; i < graph.length; i++) {
            dist[i] = Integer.MAX_VALUE;//初始距0都设成无穷大
        }
        //S，V互补
        S.add(0);
        for (int i = 1; i < graph.length; i++) {
            V.add(i);
        }
        while(V.size() != 0) {
            int s = S.get(S.size()-1);//上次加入的已确认最短路径顶点
            int minV = -1;
            int minPath = Integer.MAX_VALUE;
            for(int v : V) {
                if(graph[s][v] != -1) {
                    dist[v] = Math.min(dist[v], dist[s] + graph[s][v]);//更新V中顶点路径
                }
                if(dist[v] <= minPath) {//取出该轮V中顶点距0最短路径
                    minV = v;
                    minPath = dist[v];
                }
            }
            S.add(minV);
            V.remove(Integer.valueOf(minV));
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0,10,-1,-1,-1,3},
                {-1,0,7,5,-1,-1},
                {-1,-1,0,-1,-1,-1},
                {3,-1,4,0,7,-1},
                {-1,-1,-1,-1,0,-1},
                {-1,2,-1,6,1,0}
        };
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.getMinPaths(graph)));
    }
}

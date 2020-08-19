package 贪心法.最小生成树.Kruskal算法;

import java.util.*;

/**
 * 时间复杂度o(mlogn)，m边数，n顶点数；
 * 证明方法：短接操作、数学归纳、假设最优然后替换反证；
 * 应用：相似数据分类（单链聚类），每类内部个体value接近，不同类个体value远离；
 */
public class Solution {
    public List<int[]> getMinSpanningTree(int[][] graph) {
        List<int[]> res = new ArrayList<>();
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = i+1; j < graph.length; j++) {
                if(graph[i][j] != -1) {
                    edges.add(new int[]{i, j});
                }
            }
        }
        Comparator<int[]> cmp = new Comparator<>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return graph[t1[0]][t1[1]] - graph[t2[0]][t2[1]];
            }
        };
        edges.sort(cmp);//对边按长度排序
        int count = 0;
        int[] connections = new int[graph.length];//记录连通分支，连通分支标识
        for (int i = 0; i < connections.length; i++) {
            connections[i] = i;
        }
        for(int[] edge : edges) {
            int c1 = connections[edge[0]];
            int c2 = connections[edge[1]];
            if(c1 != c2) {//顶点连通分支不同就选取该边，再同步两个分支标识
                res.add(edge);
                for (int i = 0; i < connections.length; i++) {
                    if(connections[i] == c2) {
                        connections[i] = c1;
                    }
                }
                count++;
            }
            if(count == graph.length-1) {
                break;
            }
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

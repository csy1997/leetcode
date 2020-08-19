package 回溯算法与搜索.货郎问题;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int[][] graph;
    List<Integer> S;//已选顶点
    List<Integer> V;//未选顶点
    int[] minEdge;//记录每个顶点邻接的最小边长
    int length;//当前路径长度
    List<Integer> res;
    int minLength;

    public int getMinCircle(int[][] graph) {
        if(graph.length == 0) {
            return -1;
        }
        this.graph = graph;
        this.S = new ArrayList<>();
        S.add(0);
        this.V = new ArrayList<>();
        for (int i = 1; i < graph.length; i++) {
            V.add(i);
        }
        this.minEdge = new int[graph.length];
        this.length = 0;
        this.res = new ArrayList<>();
        this.minLength = Integer.MAX_VALUE;
        for (int i = 0; i < graph.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < graph.length; j++) {
                if(i != j && graph[i][j] != -1) {
                    min = Math.min(min, graph[i][j]);
                }
            }
            if(min == Integer.MAX_VALUE) {//有一个顶点没有邻接边就无法形成回路
                return minLength;
            }
            minEdge[i] = min;
        }
        dfs();
        return minLength;
    }

    public void dfs() {
        if(!isProbMin()) {//分支限界剪枝
            return;
        }
        if(V.size() == 0) {
            if(graph[S.get(S.size()-1)][S.get(0)] == -1) {
                return;
            }
            int temp = length + graph[S.get(S.size()-1)][S.get(0)];
            if(temp < minLength) {//形成环后还需要和最小的比一下（代价函数只说明可能小于界）
                minLength = temp;
                res = (List) ((ArrayList) S).clone();
            }
            return;
        }
        int s = S.get(S.size()-1);
        for(int i = 0; i < V.size(); i++) {
            int v = V.get(i);
            if(graph[s][v] != -1) {//当前顶点和上个选的顶点有边就继续
                V.remove(i);
                S.add(v);
                length += graph[s][v];
                dfs();
                length -= graph[s][v];
                S.remove(S.size()-1);
                V.add(i, v);
            }
        }
    }

    /**
     * 代价函数：如果当前已选路径长度加上剩下未选顶点邻接的最短边（包括当前选的节点）之和都不大于当前界
     * @return
     */
    public boolean isProbMin() {
        int l = length + minEdge[S.get(S.size()-1)];
        for(int v : V) {
            l += minEdge[v];
        }
        if(l < minLength) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] graph = {
//                {0,5,9,4},
//                {6,0,13,2},
//                {9,13,0,7},
//                {4,2,7,0}
//        };
        int[][] graph = {
                {0,10,-1,-1,-1,3},
                {-1,0,7,5,4,5},
                {1,-1,0,6,-1,-1},
                {3,-1,4,0,7,-1},
                {-1,-1,-1,3,0,-1},
                {-1,2,-1,6,1,0}
        };
        Solution sol = new Solution();
        System.out.println(sol.getMinCircle(graph));
        System.out.println(sol.res);
    }
}

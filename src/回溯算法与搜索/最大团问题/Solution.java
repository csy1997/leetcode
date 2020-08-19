package 回溯算法与搜索.最大团问题;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int count;
    int max;
    List<Integer> points;
    List<Integer> res;

    public List<Integer> getMaxClique(boolean[][] graph) {
        count = 0;
        max = 0;
        points = new ArrayList<>();
        res = new ArrayList<>();
        dfs(graph, 0);
        return res;
    }

    public void dfs(boolean[][] graph, int i) {
        if(count+graph.length-i <= max) {//分支限界代价函数：当前团大小加上后续所有顶点数依然不大于当前界
            return;
        }
        if(i == graph.length) {//遍历完叶子即确定最优解
            max = count;
            res = (List)((ArrayList) points).clone();
            return;
        }
        for(int j : points) {
            if(!graph[j][i]) {//i顶点和当前团中某顶点没有边则不加i顶点，直接考虑下一层
                dfs(graph, i+1);
                return;
            }
        }
        //循环两次，加该顶点和不加，都需要进入下一层
        points.add(i);
        count++;
        dfs(graph, i+1);
        count--;
        points.remove(points.size()-1);
        dfs(graph, i+1);
    }

    public static void main(String[] args) {
        boolean[][] graph = new boolean[5][5];
        graph[0][1] = true;
        graph[0][2] = true;
        graph[0][3] = true;
        graph[0][4] = true;
        graph[1][3] = true;
        graph[2][3] = true;
        graph[2][4] = true;
        graph[3][4] = true;

        graph[1][0] = true;
        graph[2][0] = true;
        graph[3][0] = true;
        graph[4][0] = true;
        graph[3][1] = true;
        graph[3][2] = true;
        graph[4][2] = true;
        graph[4][3] = true;

        Solution sol = new Solution();
        System.out.println(sol.getMaxClique(graph));
//        System.out.println(sol.max);
    }
}

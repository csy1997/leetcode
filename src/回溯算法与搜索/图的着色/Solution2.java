package 回溯算法与搜索.图的着色;

import java.util.Arrays;
import java.util.HashSet;

/**
 * o(n*x^n)，x为第一次到达叶子的best最少着色数(<=n)，解向量中每个节点位置固定，每个节点在搜索中可以选择多个颜色
 * 根据对称性、分支限界等剪枝后很快，效率高
 */
public class Solution2 {
    int count = 0;//记录循环次数
    int max;//记录当前最大色
    int[] colors;//记录每个顶点颜色，初始都为0色
    int best;//最少着色个数
    int[] bestColors;//最少着色对应的顶点颜色

    public int graphColoring(boolean[][] graph) {
        max = -1;
        best = graph.length;
        colors = new int[graph.length];
        dfs(graph, 0);
        return best;
    }

    public void dfs(boolean[][] graph, int i) {//i代表第i个顶点，也就是遍历顶点顺序不变，但每个顶点不光选取合适的最小色
        count++;
        if(i == graph.length) {
            best = max;
            bestColors = colors.clone();
            return;
        }
        HashSet<Integer> set = new HashSet<>();//记录当前顶点连接的颜色种类
        for (int j = 0; j < i; j++) {//选出与i节点连接的颜色
            if(graph[j][i]) {
                set.add(colors[j]);
            }
        }
        int temp = max;
        //i顶点选择颜色需小于目前选取的最优解对应的最大色(多米洛性质)，作为分支限界的代价函数；
        //且不大于当前情况最大色+1，由于跳过地选择颜色与不跳过本质是重复的(交换颜色)
        for (; colors[i] < best && colors[i] <= max+1; colors[i]++) {//best在到达树叶子时改变，max每层都可能改变
            if(!set.contains(colors[i])) {
                max = Math.max(max, colors[i]);
                dfs(graph, i+1);
                max = temp;
            }
        }
        colors[i] = 0;//不用放循环里回溯，循环结束后归零即可
        set.clear();
    }

    public static void main(String[] args) {
        boolean[][] graph = new boolean[1][1];
        Solution2 sol = new Solution2();
        System.out.println(sol.graphColoring(graph));
        System.out.println(Arrays.toString(sol.bestColors));
        System.out.println(sol.count);
    }
}

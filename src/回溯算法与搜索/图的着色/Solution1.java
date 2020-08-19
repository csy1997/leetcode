package 回溯算法与搜索.图的着色;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * o(n*n!)，用不同的顶点顺序来贪心着色，来考察所有情况
 * 剪枝后也有很多重复，效率低
 */
public class Solution1 {
    int count = 0;//记录循环次数
    int max;//记录当前最大色
    int[] colors;//记录每个顶点颜色，初始都为0色
    int best;//最少着色个数
    int[] bestColors;//最少着色对应的顶点颜色
    List<Integer> V;//未着色的顶点集
    List<Integer> S;//已着色的顶点集
    HashSet<Integer> set;//记录当前顶点连接的颜色种类

    public int graphColoring(boolean[][] graph) {
        max = -1;
        best = graph.length;
        colors = new int[graph.length];
        S = new ArrayList<>();
        V = new ArrayList<>();
        set = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            V.add(i);
        }
        dfs(graph);
        return best;
    }

    public void dfs(boolean[][] graph) {
        count++;
        if(V.size() == 0) {
            best = max;
            bestColors = colors.clone();
            return;
        }
        for (int i = 0; i < V.size(); i++) {//按不同顶点顺序构造树
            int chosen = V.get(i);
            for(int point : S) {//找和chosen连接的所有颜色
                if(graph[point][chosen]) {
                    set.add(colors[point]);
                }
            }
            while(set.contains(colors[chosen])) {
                colors[chosen]++;//找合适的最小色
            }
            set.clear();
            int temp = max;
            max = Math.max(max, colors[chosen]);
            if(max >= best) {//分支限界条件为当前最大色已超过最优解的最大色，不用继续搜索子树直接回溯
                max = temp;
                colors[chosen] = 0;
                continue;
            }
            V.remove(i);
            S.add(chosen);
            dfs(graph);
            S.remove(S.size()-1);
            V.add(i, chosen);
            max = temp;
            colors[chosen] = 0;
        }
    }

    public static void main(String[] args) {
        boolean[][] graph = new boolean[1][1];
        Solution1 sol = new Solution1();
        System.out.println(sol.graphColoring(graph));
        System.out.println(Arrays.toString(sol.bestColors));
        System.out.println(sol.count);
    }
}

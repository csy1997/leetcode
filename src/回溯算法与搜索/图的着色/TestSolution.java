package 回溯算法与搜索.图的着色;

import org.junit.Test;

public class TestSolution {
    static boolean[][] graph;
    static {
        graph = new boolean[5][5];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if(i != j) {
                    graph[i][j] = true;
                }
            }
        }

//        graph = new boolean[4][4];
//        graph[0][1] = true;
//        graph[1][3] = true;
//        graph[2][3] = true;
//
//        graph[1][0] = true;
//        graph[3][1] = true;
//        graph[3][2] = true;

//        graph = new boolean[7][7];
//        graph[0][1] = true;
//        graph[1][2] = true;
//        graph[1][6] = true;
//        graph[0][6] = true;
//        graph[2][6] = true;
//        graph[0][5] = true;
//        graph[5][6] = true;
//        graph[2][3] = true;
//        graph[3][5] = true;
//        graph[4][5] = true;
//        graph[3][4] = true;
//
//        graph[1][0] = true;
//        graph[2][1] = true;
//        graph[6][1] = true;
//        graph[6][0] = true;
//        graph[6][2] = true;
//        graph[5][0] = true;
//        graph[6][5] = true;
//        graph[3][2] = true;
//        graph[5][3] = true;
//        graph[5][4] = true;
//        graph[4][3] = true;
    }

    @Test
    public void testSolution1() {
        Solution1 sol = new Solution1();
        System.out.println(sol.graphColoring(graph));
//        System.out.println(Arrays.toString(sol.bestColors));
//        System.out.println(sol.count);
    }

    @Test
    public void testSolution2() {
        Solution2 sol = new Solution2();
        System.out.println(sol.graphColoring(graph));
//        System.out.println(Arrays.toString(sol.bestColors));
//        System.out.println(sol.count);
    }
}

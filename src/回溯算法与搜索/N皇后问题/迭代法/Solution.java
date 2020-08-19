package 回溯算法与搜索.N皇后问题.迭代法;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    int sum = 0;
    Stack<Integer> st = new Stack<>();//栈记录后续不能放的位置
    List<Integer> list;//记录皇后向量，下标代表行，数值代表列
    public List<List<Integer>> res;
    int[] trace;//记录当前每行遍历的位置
    int[] count;//记录每行增加的不可放位置(适用于连续回溯)

    public int solveNQueens(int n) {
        this.res = new ArrayList<>();
        this.list = new ArrayList<>();
        if(n == 0){
            return sum;
        }
        this.trace = new int[n];
        this.count = new int[n];
        if(n == 1) {
            res.add(new ArrayList<>(){{add(0);}});
            sum++;
            return sum;
        }
        int i = 0;
        while(true) {
            for (; i < n; i++) {
                int m = n;
                if(i == 0 || (i == 1 && n%2 == 1 && list.get(0) == n/2)) {//同递归法对称性
                    m = (n+1)/2;
                }
                for (; trace[i] < m; trace[i]++) {
                    if (!st.contains(i * n + trace[i])) {//代表第i行j列的位置能放
//                    int count = 0;
                        trace[i] = trace[i];
                        for (int k = i + 1; k < n; k++) {//该位置向下，左下，右下逐行的位置都不能放，加入栈
                            st.push(k * n + trace[i]);
                            count[i]++;
                            if (trace[i] - k + i >= 0) {
                                st.push(k * n + trace[i] - k + i);
                                count[i]++;
                            }
                            if (trace[i] + k - i < n) {
                                st.push(k * n + trace[i] + k - i);
                                count[i]++;
                            }
                        }
                        list.add(trace[i]);
                        break;
                    }
                }
                if (trace[i] == m) {//说明该循环对应子树i行没有合适的，直接退出然后回溯
                    break;
                }
            }
            if (i == n) {//说明每行都取到合适的了，记录解后回溯到最后一行即i-1行下一个位置
                i--;
                sum+=2;
                res.add((List) ((ArrayList) list).clone());
                res.add(getSymmetry(list, n));
            } else {//说明有一(i)行没取到合适的，回溯到第i-1行下一个位置
                trace[i] = 0;//该行的trace刷新为0
                i--;
            }
            if(i == -1) {//右子树全考虑完，回溯完成
                break;
            }
            trace[i]++;//继续遍历i-1行下一个位置
            list.remove(i);
            while (count[i] != 0) {
                st.pop();
                count[i]--;
            }
        }
        return sum;
    }

    public List<Integer> getSymmetry(List<Integer> list, int n) {
        List<Integer> res = new ArrayList<>();
        for (Integer integer : list) {
            res.add(n - 1 - integer);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solveNQueens(1));
        System.out.println(sol.res);
    }
}

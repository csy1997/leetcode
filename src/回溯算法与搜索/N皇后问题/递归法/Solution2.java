package 回溯算法与搜索.N皇后问题.递归法;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    int sum = 0;
    Stack<Integer> st = new Stack<>();//栈记录后续不能放的位置
    List<Integer> list;//记录皇后向量，下标代表行，数值代表列
    public List<List<Integer>> res;

    public int solveNQueens(int n) {
        this.res = new ArrayList<>();
        this.list = new ArrayList<>();
        if(n == 0){
            return sum;
        }
        if(n == 1) {
            res.add(new ArrayList<>(){{add(0);}});
            sum++;
            return sum;
        }
        dfs(0, n);
        return sum;
    }

    public void dfs(int i, int n) {
        if (i == n) {
            sum+=2;//本身加上对称的
            res.add((List)((ArrayList)list).clone());
            res.add(getSymmetry(list, n));
            return;
        }
        int m = n;
        if(i == 0) {//第一行只需要遍历一半，另一半可根据对称性得到
            m = (n+1)/2;
        } else if(i == 1 && n%2 == 1 && list.get(0) == n/2) {//若n为奇数，且第一行选到最中间数时，第二行也只需要遍历一半
            m = n/2;
        }
        for (int j = 0; j < m; j++) {
            if (!st.contains(i * n + j)) {//代表第i行j列的位置能放
                int count = 0;
                for (int k = i + 1; k < n; k++) {//该位置向下，左下，右下逐行的位置都不能放，加入栈
                    st.push(k * n + j);
                    count++;
                    if (j - k + i >= 0) {
                        st.push(k * n + j - k + i);
                        count++;
                    }
                    if (j + k - i < n) {
                        st.push(k * n + j + k - i);
                        count++;
                    }
                }
                list.add(j);
                dfs(i + 1, n);//在本行当前选择基础上考虑下一行
                list.remove(i);//回溯到当前行继续遍历
                while (count != 0) {
                    st.pop();
                    count--;
                }
            }
        }
    }

    public List<Integer> getSymmetry(List<Integer> list, int n) {
        List<Integer> res = new ArrayList<>();
        for (Integer integer : list) {
            res.add(n - 1 - integer);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println(sol.solveNQueens(4));
        System.out.println(sol.res);
    }
}

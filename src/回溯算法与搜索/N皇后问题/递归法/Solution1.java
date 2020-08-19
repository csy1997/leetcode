package 回溯算法与搜索.N皇后问题.递归法;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    int sum = 0;
    int[][] arr;//数组记录后续可以放的位置，0为可放位置
    public List<List<Integer>> res;
    List<Integer> list;

    public int solveNQueens(int n) {
        this.res = new ArrayList<>();
        this.list = new ArrayList<>();
        this.arr = new int[n][n];
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

    public void dfs(int i, int n){
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
        for(int j = 0; j < m; j++){
            if(arr[i][j] == 0){
                for(int k = i+1; k < n; k++){//不能放的位置加1
                    arr[k][j]++;
                    if(j-k+i >= 0){
                        arr[k][j-k+i]++;
                    }
                    if(j+k-i < n){
                        arr[k][j+k-i]++;
                    }
                }
                list.add(j);
                dfs(i+1, n);
                list.remove(i);
                for(int k = i+1; k < n; k++){//回溯
                    arr[k][j]--;
                    if(j-k+i >= 0){
                        arr[k][j-k+i]--;
                    }
                    if(j+k-i < n){
                        arr[k][j+k-i]--;
                    }
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
        Solution1 sol = new Solution1();
        System.out.println(sol.solveNQueens(7));
        System.out.println(sol.res);
    }
}

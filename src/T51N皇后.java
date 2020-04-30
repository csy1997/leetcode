import java.util.ArrayList;
import java.util.List;

public class T51N皇后 {
    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    char[] ch;
    int[][] bool;
    public List<List<String>> solveNQueens(int n) {
        if(n == 0){
            return res;
        }
        ch = new char[n];
        bool = new int[n][n];
        for(int i = 0; i < n; i++){
            ch[i] = '.';
        }
        dfs(0, n);
        System.out.println(res);
        return res;
    }

    public void dfs(int i, int n){
        if(i == n){
            res.add((List)((ArrayList)list).clone());
            return;
        }
        for(int j = 0; j < n; j++){
            if(bool[i][j] == 0){
                ch[j] = 'Q';
                String temp = String.valueOf(ch);
                ch[j] = '.';
                for(int k = i+1; k < n; k++){
                    bool[k][j]++;
                    if(j-k+i >= 0){
                        bool[k][j-k+i]++;
                    }
                    if(j+k-i < n){
                        bool[k][j+k-i]++;
                    }
                }
                list.add(temp);
                dfs(i+1, n);
                list.remove(i);
                for(int k = i+1; k < n; k++){
                    bool[k][j]--;
                    if(j-k+i >= 0){
                        bool[k][j-k+i]--;
                    }
                    if(j+k-i < n){
                        bool[k][j+k-i]--;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        T51N皇后 sol = new T51N皇后();
        sol.solveNQueens(8);
//        char[] ch = {'.', '.', '.', '.'};
//        System.out.println(String.valueOf(ch));
    }
}

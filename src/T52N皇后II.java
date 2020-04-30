import java.util.Stack;

public class T52N皇后II {
    int sum = 0;
    Stack<Integer> st = new Stack<>();
    public int totalNQueens(int n) {
        if(n == 0){
            return 0;
        }
        dfs(0, n);
        System.out.println(sum);
        return sum;
    }

    public void dfs(int i, int n){
        if(i == n){
            sum++;
            return;
        }
        for(int j = 0; j < n; j++){
            if(!st.contains(i*n+j)){
                int count = 0;
                for(int k = i+1; k < n; k++){
                    st.push(k*n+j);
                    count++;
                    if(j-k+i >= 0){
                        st.push(k*n+j-k+i);
                        count++;
                    }
                    if(j+k-i < n){
                        st.push(k*n+j+k-i);
                        count++;
                    }
                }
                dfs(i+1, n);
                while(count != 0){
                    st.pop();
                    count--;
                }
            }
        }
    }

    public static void main(String[] args) {
        T52N皇后II sol = new T52N皇后II();
        sol.totalNQueens(4);
    }
}

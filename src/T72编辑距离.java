public class T72编辑距离 {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        dp[0][0] = 0;
        for(int i = 1; i <= l1; i++){
            dp[i][0] = i;
        }
        for(int i = 1; i <= l2; i++){
            dp[0][i] = i;
        }
        for(int i = 1; i <= l1; i++){
            for(int j = 1; j <= l2; j++){
                dp[i][j] = dp[i-1][j-1];
                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    dp[i][j]++;
                }
                dp[i][j] = Math.min(dp[i][j], Math.min(dp[i-1][j], dp[i][j-1])+1);
            }
        }
        for(int[] x : dp){
            for(int y : x){
                System.out.print(y + " ");
            }
            System.out.println();
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        T72编辑距离 sol = new T72编辑距离();
        String word1 = "zoologicoarchaeologist";
        String word2 = "zoogeologist";
        System.out.println(sol.minDistance(word1, word2));
    }
}

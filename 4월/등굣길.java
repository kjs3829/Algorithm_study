// Programmers Level3
// DP
// 50분 소요
public class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        dp[1][1] = 1;
        for (int[] puddle : puddles) dp[puddle[1]][puddle[0]] = -1;
        for (int r=1; r<=n; r++) {
            for (int c=1; c<=m; c++) {
                if (r==1 && c==1) continue;
                if (dp[r][c] == -1) {
                    dp[r][c] = 0;
                    continue;
                }
                dp[r][c] = dp[r-1][c]%1000000007 + dp[r][c-1]%1000000007;
            }
        }

        return dp[n][m]%1000000007;
    }
}

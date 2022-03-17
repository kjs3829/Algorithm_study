import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 11909 GOLD5
// 다이나믹 프로그래밍
// 42분 소요
public class 배열탈출_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int r=0; r<n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c=0; c<n; c++) map[r][c] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][n];
        for (int r=1; r<n; r++) {
            int cost = map[r-1][0] > map[r][0] ? 0 : map[r][0]-map[r-1][0]+1;
            dp[r][0] = dp[r-1][0]+cost;
        }
        for (int c=1; c<n; c++) {
            int cost = map[0][c-1] > map[0][c] ? 0 : map[0][c]-map[0][c-1]+1;
            dp[0][c] = dp[0][c-1]+cost;
        }
        for (int r=1; r<n; r++) {
            for (int c=1; c<n; c++) {
                int lcost = map[r][c-1] > map[r][c] ? 0 : map[r][c]-map[r][c-1]+1;
                int ucost = map[r-1][c] > map[r][c] ? 0 : map[r][c]-map[r-1][c]+1;
                dp[r][c] = Math.min(dp[r][c-1]+lcost, dp[r-1][c]+ucost);
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}

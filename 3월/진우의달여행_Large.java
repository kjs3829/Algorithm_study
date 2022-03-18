import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 17485 GOLD5
// 다이나믹 프로그래밍
// 30분 소요
public class 진우의달여행_Large {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int r=0; r<n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c=0; c<m; c++) map[r][c] = Integer.parseInt(st.nextToken());
        }
        int[][][] dp = new int[n][m][3];
        for (int c=0; c<m; c++) dp[0][c] = new int[]{map[0][c],map[0][c],map[0][c]};
        for (int r=1; r<n; r++) {
            for (int c=0; c<m; c++) {
                if (c>0) dp[r][c][0] = map[r][c]+Math.min(dp[r-1][c-1][1],dp[r-1][c-1][2]);

                if (c == 0) dp[r][c][1] = map[r][c]+dp[r-1][c][2];
                else if (c == m-1) dp[r][c][1] = map[r][c]+dp[r-1][c][0];
                else dp[r][c][1] = map[r][c]+Math.min(dp[r-1][c][0],dp[r-1][c][2]);

                if (c<m-1) dp[r][c][2] = map[r][c]+Math.min(dp[r-1][c+1][0],dp[r-1][c+1][1]);
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int c=0; c<m; c++) {
            for (int i=0; i<3; i++) {
                if ((c==0 && i==0) || (c==m-1 && i==2)) continue;
                answer = Math.min(answer, dp[n-1][c][i]);
            }
        }
        System.out.println(answer);
    }
}

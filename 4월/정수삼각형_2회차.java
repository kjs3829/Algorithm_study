// Programmers Level3
// DP
// 14분 소요
public class 정수삼각형_2회차 {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        int width = triangle[height-1].length;
        int[][] dp = new int[height][width];
        dp[0][0] = triangle[0][0];
        dp[1][0] = triangle[1][0]+dp[0][0];
        dp[1][1] = triangle[1][1]+dp[0][0];

        for (int r=2; r<height; r++) {
            for (int c=0; c<=r; c++) {
                if (c==0) dp[r][c] = dp[r-1][c]+triangle[r][c];
                else if (c==r) dp[r][c] = dp[r-1][c-1]+triangle[r][c];
                else dp[r][c] = Math.max(dp[r-1][c-1],dp[r-1][c])+triangle[r][c];
            }
        }

        int answer = 0;
        for (int c=0; c<width; c++) answer = Math.max(answer, dp[height-1][c]);
        return answer;
    }
}

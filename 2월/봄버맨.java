import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// BOJ 16918 SILVER1
// 구현, 그래프탐색
// 31분 소요
public class 봄버맨 {
    private static int r, c;
    private static final int[] dr = new int[]{0,0,-1,1};
    private static final int[] dc = new int[]{1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[r][c];
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) arr[i][j] = -1;
        }
        for (int i=0; i<r; i++) {
            String s = br.readLine();
            for (int j=0; j<c; j++) {
                if (s.charAt(j) == 'O') arr[i][j] = 0;
            }
        }

        for (int time=2; time<=n; time++) {
            if (time % 2 == 0) {
                for (int row = 0; row < r; row++) {
                    for (int col = 0; col < c; col++) {
                        if (arr[row][col] == -1) arr[row][col] = time;
                    }
                }
            } else bomb(arr, time);
        }

        printResult(arr);
    }

    private static void bomb(int[][] arr, int time) {
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                if (time - arr[row][col] == 3) {
                    arr[row][col] = -1;
                    for (int l = 0; l < 4; l++) {
                        int nr = row + dr[l];
                        int nc = col + dc[l];
                        if (0 <= nr && nr < r && 0 <= nc && nc < c && time - arr[nr][nc] != 3) arr[nr][nc] = -1;
                    }
                }
            }
        }
    }

    private static void printResult(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : arr) {
            for (int col : row) {
                if (col == -1) sb.append(".");
                else sb.append("O");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

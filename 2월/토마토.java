import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ 7576 GOLD5
// 그래프 탐색, 너비 우선 탐색
// 1시간 15분 소요
public class 토마토 {
    public static int m, n;
    public static int[][] arr;
    public static int[] dr = new int[]{0,0,1,-1};
    public static int[] dc = new int[]{1,-1,0,0};
    public static int[][] visit;
    public static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new int[n][m];
        for (int r=0; r<n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c=0; c<m; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
                if (arr[r][c] == 1) {
                    q.offer(new int[]{r,c});
                    visit[r][c] = 1;
                } else if (arr[r][c] == -1) visit[r][c] = -1;
            }
        }

        bfs();
        int answer = 0;
        boolean possible = true;
        for (int r=0; r<n; r++) {
            if (!possible) break;
            for (int c=0; c<m; c++) {
                if (visit[r][c] == 0) {
                    answer = 0;
                    possible = false;
                    break;
                }
                answer = Math.max(answer, visit[r][c]);
            }
        }
        System.out.println(answer-1);
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            int[] p = q.poll();
            int r = p[0];
            int c = p[1];
            for (int i=0; i<4; i++) {
                int nr = r+dr[i];
                int nc = c+dc[i];
                if (0<=nr && nr<n && 0<=nc && nc<m && visit[nr][nc] == 0) {
                    q.offer(new int[]{nr,nc});
                    visit[nr][nc] = visit[r][c]+1;
                }
            }
        }
    }
}

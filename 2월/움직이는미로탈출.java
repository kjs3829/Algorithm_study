import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// BOJ 16954 GOLD4
// 그래프 탐색
// 1시간 10분 소요
public class 움직이는미로탈출 {
    private static final int n = 8;
    private static final int[][] map = new int[n][n];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int r=0; r<n; r++) {
            char[] cr = br.readLine().toCharArray();
            for (int c=0; c<n; c++) {
                if (cr[c] == '.') map[r][c] = 0;
                else map[r][c] = 1;
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        int[] dr = new int[]{0,0,0,1,-1,1,1,-1,-1};
        int[] dc = new int[]{0,1,1,0,0,-1,1,-1,1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n-1,0,0});
        int depth = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int r = p[0], c= p[1], d = p[2];
            if (d >= n) return 1;
            if (d != depth) {
                depth = d;
                down();
            }
            if (map[r][c] == 0) {
                for (int i=0; i<9; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (0<=nr && nr<n && 0<=nc && nc<n && map[nr][nc] == 0)
                        q.offer(new int[]{nr,nc,d+1});
                }
            }

        }
        return 0;
    }

    private static void down() {
        for (int r=n-1; r>0; r--) {
            for (int c=0; c<n; c++) {
                map[r][c] = map[r-1][c];
            }
        }
        for (int c=0; c<n; c++) map[0][c] = 0;
    }
}

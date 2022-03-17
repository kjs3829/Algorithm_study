import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BOJ 11909 GOLD5
// 다익스트라
// 24분 소요
public class 배열탈출_다익스트라 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int r=0; r<n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c=0; c<n; c++) map[r][c] = Integer.parseInt(st.nextToken());
        }
        int[][] dijkArr = dijk(map, n);
        System.out.println(dijkArr[n-1][n-1]);
    }

    private static int[][] dijk(int[][] map, int n) {
        int[] dr = new int[]{0,1};
        int[] dc = new int[]{1,0};
        int[][] dijkArr = new int[n][n];
        for (int r=0; r<n; r++) {
            for (int c=0; c<n; c++) {
                dijkArr[r][c] = Integer.MAX_VALUE;
            }
        }
        dijkArr[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2)->i1[2]-i2[2]);
        pq.offer(new int[]{0,0,0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int r = p[0], c = p[1], cost = p[2];
            if (cost > dijkArr[r][c]) continue;
            for (int i=0; i<2; i++) {
                int nr = r+dr[i], nc = c+dc[i];
                if (nr<n && nc<n) {
                    int nCost = map[r][c] > map[nr][nc] ? 0 : map[nr][nc]-map[r][c]+1;
                    if (dijkArr[nr][nc] > cost+nCost) {
                        dijkArr[nr][nc] = cost+nCost;
                        pq.offer(new int[]{nr,nc,dijkArr[nr][nc]});
                    }
                }
            }
        }
        return dijkArr;
    }
}

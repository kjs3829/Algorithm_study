import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ 2206 GOLD4
// 너비 우선 탐색
// 1시간 30분 소요
public class 벽부수고이동하기 {
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int r=0; r<n; r++) {
            String row = br.readLine();
            for (int c=0; c<m; c++) {
                map[r][c] = Integer.parseInt(String.valueOf(row.charAt(c)));
            }
        }

        System.out.println(bfs(map));
    }
    private static int bfs(int[][] map) {
        int[] dr = new int[]{0,0,1,-1};
        int[] dc = new int[]{1,-1,0,0};
        int[][][] visit = new int[n][m][2];
        Queue<int[]> q = new LinkedList<>();  //[r,c]
        q.offer(new int[]{0,0});
        visit[0][0][0] = 1;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int r = p[0], c = p[1];
            for (int i=0; i<4; i++) {
                int nr=r+dr[i], nc=c+dc[i];
                if (0<=nr && nr<n && 0<=nc && nc<m) { //배열 범위 체크
                    if (map[nr][nc] == 1) { //다음 노드가 벽인 경우
                        if (visit[r][c][0] != 0 && visit[nr][nc][1] == 0) { //현재 노드까지 벽을 뚫고 오지 않은 경우가 있는경우
                            visit[nr][nc][1] = visit[r][c][0] + 1;
                            q.offer(new int[]{nr,nc});
                        }
                    } else { //다음 노드가 벽이 아닌경우
                        if (visit[r][c][0] != 0 && visit[nr][nc][0] == 0) {
                            visit[nr][nc][0] = visit[r][c][0] + 1;
                            q.offer(new int[]{nr,nc});
                        } else if (visit[r][c][1] != 0 && visit[nr][nc][1] == 0) {
                            visit[nr][nc][1] = visit[r][c][1] + 1;
                            q.offer(new int[]{nr,nc});
                        }
                    }
                }
            }
        }

        if (visit[n-1][m-1][0] == 0 && visit[n-1][m-1][1] == 0) return -1;
        else if (visit[n-1][m-1][0] == 0) return visit[n-1][m-1][1];
        else if (visit[n-1][m-1][1] == 0) return visit[n-1][m-1][0];
        else return Math.min(visit[n-1][m-1][0], visit[n-1][m-1][1]);
    }
}

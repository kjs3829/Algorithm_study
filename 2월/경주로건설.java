import java.util.*;

// Programmers Level3
// 그래프 탐색
// 못 풀음
public class 경주로건설 {
    private int[] dx = new int[]{1,0,-1,0}; //오,밑,왼,위
    private int[] dy = new int[]{0,1,0,-1};
    private int answer = Integer.MAX_VALUE;

    public int solution(int[][] board) {
        bfs(board, board.length);
        return answer;
    }

    private void bfs(int[][] board, int n) {
        boolean[][][] visit = new boolean[n][n][4];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,-1,0});    //[x,y,dir,cost]
        visit[0][0][0] = visit[0][0][1] = visit[0][0][2] = visit[0][0][3] = true;

        while(!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1], d = p[2], c = p[3];
            if (x == n-1 && y == n-1) answer = Math.min(answer, c);
            for (int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if (0<=nx && nx<n && 0<=ny && ny<n && board[ny][nx] != 1) {
                    int cost = d == i || d == -1 ? c+100 : c+600;
                    if (!visit[ny][nx][i] || cost <= board[ny][nx]) {
                        visit[ny][nx][i] = true;
                        board[ny][nx] = cost;
                        q.offer(new int[]{nx,ny,i,cost});
                    }
                }
            }
        }
    }
}

// Programmers Level3
// bfs구현
// 실패 : 두개의 지점을 관리하는 것이 너무 힘듬
public class 블록이동하기_실패 {
    private int[] dx = new int[]{1,0,-1,0};
    private int[] dy = new int[]{0,1,0,-1};
    private int[] rx1 = new int[]{1,1,0,0};
    private int[] ry1 = new int[]{-1,1,0,0};
    private int[] rx2 = new int[]{0,0,-1,-1};
    private int[] ry2 = new int[]{0,0,-1,1};
    private int[] cx1 = new int[]{0,0,1,1};
    private int[] cy1 = new int[]{-1,1,-1,1};
    private int[] cx2 = new int[]{-1,1,0,0};
    private int[] cy2 = new int[]{0,0,-1,1};
    private int answer = Integer.MAX_VALUE;
    private int n;

    public int solution(int[][] board) {
        n = board.length;
        boolean[][] visit1 = new boolean[n][n];
        boolean[][] visit2 = new boolean[n][n];
        visit1[0][0] = true;
        visit2[0][1] = true;
        bruteforce(visit1, visit2, board, 0, 0, 1, 0, 0, false);
        return answer;
    }

    private void bruteforce(boolean[][] visit1, boolean[][] visit2, int[][] board, int x1, int y1, int x2, int y2, int depth, boolean rotated) {
        System.out.println(x1+","+y1+","+x2+","+y2+","+depth);
        if (depth >= answer) return;

        if ((x1 == n-1 && y1 == n-1) || (x2 == n-1 && y2 == n-1)) {
            answer = answer > depth ? depth : answer;
            return;
        }

        //move
        for (int i=0; i<4; i++) {
            int nx1 = x1+dx[i], nx2 = x2+dx[i];
            int ny1 = y1+dy[i], ny2 = y2+dy[i];

            if (idxCheck(nx1,ny1,nx2,ny2) && wallCheck(board,nx1,ny1,nx2,ny2)
                    && visitCheck(visit1,visit2,nx1,ny1,nx2,ny2)) {
                visit1[ny1][nx1] = true;
                visit2[ny2][nx2] = true;
                bruteforce(visit1, visit2, board, nx1, ny1, nx2, ny2, depth+1, rotated);
                visit1[ny1][nx1] = false;
                visit2[ny2][nx2] = false;
            }
        }

        //rotate
        for (int i=0; i<4; i++) {
            int nx1 = x1+rx1[i], nx2 = x2+rx2[i];
            int ny1 = y1+ry1[i], ny2 = y2+ry2[i];

            if (idxCheck(nx1,ny1,nx2,ny2) && wallCheck(board,nx1,ny1,nx2,ny2)
                    && visitCheck(visit1,visit2,nx1,ny1,nx2,ny2)) {
                int ncx=0, ncy=0;
                if (rotated) {
                    ncx=x1+cx2[i];
                    ncy=y1+cy2[i];
                } else {
                    ncx=x1+cx1[i];
                    ncy=y1+cy1[i];
                }
                if (0<=ncx && ncx<n && 0<=ncy && ncy<n && board[ncy][ncx] == 0)
                    visit1[ny1][nx1] = true;
                visit2[ny2][nx2] = true;
                bruteforce(visit1, visit2, board, nx1, ny1, nx2, ny2, depth+1, !rotated);
                visit1[ny1][nx1] = false;
                visit2[ny2][nx2] = false;
            }
        }
    }

    private boolean idxCheck(int x1, int y1, int x2, int y2) {
        return 0<=x1 && x1<n && 0<=y1 && y1<n && 0<=x2 && x2<n && 0<=y2 && y2<n;
    }

    private boolean wallCheck(int[][] board, int x1, int y1, int x2, int y2) {
        return board[y1][x1] == 0 && board[y2][x2] == 0;
    }

    private boolean visitCheck(boolean[][] visit1, boolean[][] visit2, int x1, int y1, int x2, int y2) {
        return !visit1[y1][x1] || !visit2[y2][x2];
    }
}

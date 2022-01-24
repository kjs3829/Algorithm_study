import java.util.*;

// Programmers Level2
// 그래프 탐색
// 35분 소요
public class 거리두기확인하기 {
    static final int width = 5;
    static final int height = 5;
    static final int Manhattan_Distance = 2;

    public int[] solution(String[][] places) {
        int[] answer = new int[]{1,1,1,1,1};
        int answerIdx = 0;
        for (String[] place : places) {
            for (int r=0; r<height; r++) {
                if (answer[answerIdx] == 0) break;
                for (int c=0; c<width; c++) {
                    if (place[r].charAt(c) == 'P' && !isSafeFromCorona(place, r, c)) {
                        answer[answerIdx] = 0;
                        break;
                    }
                }
            }
            answerIdx++;
        }
        return answer;
    }

    public boolean isSafeFromCorona(String[] place, int sr, int sc) {
        int[] dr = new int[]{1,-1,0,0};
        int[] dc = new int[]{0,0,1,-1};
        int[][] visit = new int[height][width];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc});
        visit[sr][sc] = 1;

        while(!q.isEmpty()) {
            int[] p = q.poll();
            int r = p[0], c = p[1];
            if (visit[r][c] == Manhattan_Distance+1) continue;
            for (int i=0; i<4; i++) {
                int nr = r+dr[i], nc = c+dc[i];
                if (0<=nr && nr<height && 0<=nc && nc<width && visit[nr][nc] == 0) {
                    char cur = place[nr].charAt(nc);
                    if (cur=='O') {
                        q.offer(new int[]{nr,nc});
                        visit[nr][nc] = visit[r][c]+1;
                    }
                    else if (cur=='P') return false;
                }
            }
        }
        return true;
    }
}

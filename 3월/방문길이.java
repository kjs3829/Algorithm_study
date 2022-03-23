// Programmers Level2
// 구현
// 22분 소요
public class 방문길이 {
    private final int HEIGHT = 11;
    private final int WIDTH = 11;

    public int solution(String dirs) {
        boolean[][][] visit = new boolean[HEIGHT][WIDTH][4];
        int r = HEIGHT/2, c = WIDTH/2;
        int answer = 0;

        for (char dir : dirs.toCharArray()) {
            if (dir == 'U' && r > 0) {
                if (!visit[r][c][0]) {
                    visit[r][c][0] = true;
                    visit[r-1][c][3] = true;
                    answer++;
                }
                r--;
            } else if (dir == 'L' && c > 0) {
                if (!visit[r][c][1]) {
                    visit[r][c][1] = true;
                    visit[r][c-1][2] = true;
                    answer++;
                }
                c--;
            } else if (dir == 'R' && c < WIDTH-1) {
                if (!visit[r][c][2]) {
                    visit[r][c][2] = true;
                    visit[r][c+1][1] = true;
                    answer++;
                }
                c++;
            } else if (dir == 'D' && r < HEIGHT-1) {
                if (!visit[r][c][3]) {
                    visit[r][c][3] = true;
                    visit[r+1][c][0] = true;
                    answer++;
                }
                r++;
            }
        }

        return answer;
    }
}

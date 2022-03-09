package programmers.kakao.blind2018;

// Programmers Level2
// 구현
// 51분 소요
public class 프렌즈4블록_2회차 {
    private char[][] boardArr;

    public int solution(int m, int n, String[] board) {
        boardArr = new char[m][n];
        for (int i=0; i<m; i++) boardArr[i] = board[i].toCharArray();
        int answer = pop(m,n);
        while(isDrop(m, n)) {
            answer += pop(m,n);
        }
        return answer;
    }

    private int pop(int m, int n) {
        int popCnt = 0;
        int[][] visit = new int[m][n];

        for (int r=m-1; r>0; r--) {
            for (int c=0; c<n-1; c++) {
                char ch = boardArr[r][c];
                if (ch != '*' && ch==boardArr[r-1][c] && ch==boardArr[r-1][c+1] && ch==boardArr[r][c+1]) {
                    visit[r][c]++;
                    visit[r][c+1]++;
                    visit[r-1][c]++;
                    visit[r-1][c+1]++;
                }
            }
        }

        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (visit[r][c] != 0) {
                    boardArr[r][c] = '*';
                    popCnt++;
                }
            }
        }

        return popCnt;
    }

    private boolean isDrop(int m, int n) {
        boolean drop = false;
        for (int r=m-1; r>0; r--) {
            for (int c=0; c<n; c++) {
                if (boardArr[r][c] != '*') continue;
                int nr = r-1;
                while(nr>=0 && boardArr[nr][c] == '*') {
                    nr--;
                }
                if (nr >=0) {
                    boardArr[r][c] = boardArr[nr][c];
                    boardArr[nr][c] = '*';
                    drop = true;
                }
            }
        }
        return drop;
    }
}

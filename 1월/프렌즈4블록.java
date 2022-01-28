// Programmers Level2
// 구현
// 1시간 소요
public class 프렌즈4블록 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        while(true) {
            int[][] popBoard = pop(board, m, n);
            int popCount = countPopBlock(popBoard);
            if (popCount == 0) break;
            answer += popCount;
            dropBlock(board, popBoard, m, n);
        }
        return answer;
    }

    private int[][] pop(String[] board, int m, int n) {
        int[][] popBoard = new int[m][n];
        for(int r=0; r<m-1; r++) {
            for (int c=0; c<n-1; c++) {
                char block = board[r].charAt(c);
                if(block != '\0' && block == board[r].charAt(c+1) &&
                        block == board[r+1].charAt(c) && block == board[r+1].charAt(c+1)) {
                    popBoard[r][c]++;
                    popBoard[r+1][c]++;
                    popBoard[r][c+1]++;
                    popBoard[r+1][c+1]++;
                }
            }
        }
        return popBoard;
    }

    private void dropBlock(String[] board, int[][] popBoard, int m, int n) {
        char[][] cboard = new char[m][n];
        for (int c=0; c<n; c++) {
            int ridx = m-1;
            for (int r=m-1; r>=0; r--) {
                if (popBoard[r][c] == 0) {
                    cboard[ridx--][c] = board[r].charAt(c);
                }
            }
        }
        int idx = 0;
        for (char[] row : cboard) {
            board[idx++] = String.valueOf(row);
        }
    }

    private int countPopBlock(int[][] popBoard) {
        int popCount = 0;
        for (int[] row : popBoard) {
            for (int count : row) {
                if (count != 0) popCount++;
            }
        }
        return popCount;
    }
}

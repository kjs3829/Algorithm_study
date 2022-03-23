// Programmers Level2
// 재귀, 구현
// 12분 소요
public class 쿼드압축후개수세기 {
    private int[] answer = new int[2];
    private int[] dr = new int[]{0,0,1,1};
    private int[] dc = new int[]{0,1,0,1};

    public int[] solution(int[][] arr) {
        zip(arr, 0, 0, arr.length);
        return answer;
    }

    private void zip(int[][] arr, int sr, int sc, int len) {
        if (len == 1 || canZip(arr, sr, sc, len)) {
            answer[arr[sr][sc]]++;
            return;
        }

        for (int i=0; i<4; i++) {
            zip(arr, sr+(dr[i]*len/2), sc+(dc[i]*len/2), len/2);
        }
    }

    private boolean canZip(int[][] arr, int sr, int sc, int len) {
        int n = arr[sr][sc];

        for(int r=sr; r<sr+len; r++) {
            for (int c=sc; c<sc+len; c++) {
                if (n != arr[r][c]) return false;
            }
        }

        return true;
    }
}

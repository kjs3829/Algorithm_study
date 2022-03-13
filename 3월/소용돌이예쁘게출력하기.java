import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 1022 GOLD4
// 구현, 수학
// 50분 소요
public class 소용돌이예쁘게출력하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        prettyPrint(getMat(r1, c1, r2, c2));
    }

    private static int[][] getMat(int r1, int c1, int r2, int c2) {
        int[] dr = new int[]{0,-1,0,1}, dc = new int[]{1,0,-1,0};
        int[][] mat = new int[r2-r1+1][c2-c1+1];
        int fillCnt = 0, fullCnt = mat.length*mat[0].length;
        int num = 1, nr = 0, nc = 0, d = 0, cnt = 0, rCnt = 2;
        boolean next = false;
        while(true) {
            if (r1<=nr && nr<=r2 && c1<=nc && nc<=c2) {
                mat[nr-r1][nc-c1] = num;
                if (++fillCnt == fullCnt) break;
            }
            num++;
            cnt++;
            if (cnt == rCnt) {
                if (next) {
                    rCnt++;
                    next=false;
                } else next = true;
                d=(d+1)%4;
                cnt = 1;
            }
            nr+=dr[d];
            nc+=dc[d];
        }
        return mat;
    }

    private static void prettyPrint(int[][] mat) {
        int max = 0;
        for (int r=0; r<mat.length; r++) {
            for (int c=0; c<mat[0].length; c++) {
                max = Math.max(max, mat[r][c]);
            }
        }
        int len = String.valueOf(max).length();
        for (int r=0; r<mat.length; r++) {
            for (int c=0; c<mat[0].length; c++) {
                System.out.printf("%"+len+"s ",mat[r][c]);
            }
            System.out.println();
        }
    }
}

import java.util.ArrayList;
import java.util.List;

// Programmers Level3
// 구현
// 2시간 21분 소요
public class 기둥과보설치 {
    private boolean[][][] map;
    private int tn;

    public int[][] solution(int n, int[][] build_frame) {
        tn = n;
        map = new boolean[n+1][n+1][2];
        for (int[] b : build_frame) {
            if (b[3] == 0) delete(b[0],b[1],b[2]);
            else create(b[0],b[1],b[2]);
        }
        return getResult();
    }

    private int[][] getResult() {
        List<int[]> resultList = new ArrayList<>();
        for (int x=0; x<map.length; x++) {
            for (int y= map.length-1; y>=0; y--) {
                for (int a=0; a<2; a++) {
                    if (map[y][x][a]) resultList.add(new int[]{x,tn-y,a});
                }
            }
        }
        int n = resultList.size();
        int[][] result = new int[n][3];
        for (int r=0; r<n; r++) {
            for (int c=0; c<3; c++) {
                result[r][c] = resultList.get(r)[c];
            }
        }

        return result;
    }

    private void create(int x, int y, int a) {
        y = tn - y;
        map[y][x][a] = true;
        if (!check()) map[y][x][a] = false;
    }

    private void delete(int x, int y, int a) {
        y = tn - y;
        map[y][x][a] = false;
        if (!check()) map[y][x][a] = true;
    }

    private boolean check() {
        //기둥 체크
        for (int y = tn -1; y>0; y--) {
            for (int x = 0; x< tn; x++) {
                if (map[y][x][0]) {
                    if (!map[y+1][x][0] && !map[y][x][1]) {
                        if (x == 0 || !map[y][x-1][1]) return false;
                    }
                }
            }
        }

        //보 체크
        for (int y = tn -1; y>0; y--) {
            for (int x = 0; x< tn; x++) {
                if (map[y][x][1]) {
                    if (!map[y+1][x][0] && !map[y+1][x+1][0]) {
                        if (!map[y][x+1][1] || x == 0 || !map[y][x-1][1]) return false;
                    }
                }
            }
        }
        return true;
    }
}

// Programmers Level3
// 2차원 배열, 구현
// 1시간 30분 소요
public class 자물쇠와열쇠 {
    private int m, n;
    public boolean solution(int[][] key, int[][] lock) {
        m = key.length;
        n = lock.length;
        int[][] map = new int[n+(m-1)*2][n+(m-1)*2];
        for (int r=m-1; r<n+m-1; r++) {
            for (int c=m-1; c<n+m-1; c++) {
                map[r][c] = lock[r-m+1][c-m+1];
            }
        }

        for (int i=0; i<4; i++) {
            if (pick(map, key)) return true;
            key = rotateKey(key);
        }
        return false;
    }

    private boolean pick(int[][] map, int[][] key) {
        for (int offsetR=0; offsetR<=map.length-m; offsetR++) {
            for (int offsetC=0; offsetC<=map.length-m; offsetC++) {
                int[][] newMap = new int[map.length][map.length];
                for (int r=0; r<m; r++) {
                    for (int c=0; c<m; c++) {
                        newMap[r+offsetR][c+offsetC] = key[r][c];
                    }
                }
                if (check(newMap, map)) return true;
            }
        }
        return false;
    }

    private boolean check(int[][] newMap, int[][] map) {
        for (int r=m-1; r<n+m-1; r++) {
            for (int c=m-1; c<n+m-1; c++) {
                if (newMap[r][c] == 1 && map[r][c] == 1) return false;
                if (newMap[r][c] == 0 && map[r][c] == 0) return false;
            }
        }
        return true;
    }

    private int[][] rotateKey(int[][] key) {
        int[][] rotatedKey = new int[m][m];
        for (int r=0; r<m; r++) {
            for (int c=0; c<m; c++) {
                rotatedKey[c][m-1-r] = key[r][c];
            }
        }
        return rotatedKey;
    }
}

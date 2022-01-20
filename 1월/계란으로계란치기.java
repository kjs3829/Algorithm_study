import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ 16987 SILVER1
// 백트래킹
// 30분 소요
public class 계란으로계란치기 {
    public static int n;
    public static boolean[] isBroken;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        isBroken = new boolean[n];
        int[][] eggs = new int[n][2];
        for (int i=0; i<n; i++) {
            String[] sp = br.readLine().split(" ");
            eggs[i][0] = Integer.parseInt(sp[0]);
            eggs[i][1] = Integer.parseInt(sp[1]);
        }
        backTracking(0,eggs,isBroken,0);
        System.out.println(answer);

    }

    public static void backTracking(int choice, int[][] eggs, boolean[] isBroken, int brokenCnt) {
        if (choice>=eggs.length) {
            answer = Math.max(answer,brokenCnt);
            return;
        }
        if (isBroken[choice] || brokenCnt == n-1) {
            backTracking(choice+1,eggs,isBroken,brokenCnt);
            return;
        }

        for (int i=0; i<n; i++) {
            if (choice == i || isBroken[i]) continue;
            int s1 = eggs[choice][0];
            int s2 = eggs[i][0];
            int backupCnt = brokenCnt;
            eggs[choice][0] -= eggs[i][1];
            eggs[i][0] -= eggs[choice][1];
            if (eggs[choice][0] <= 0) {
                isBroken[choice] = true;
                brokenCnt++;
            }
            if (eggs[i][0] <= 0) {
                isBroken[i] = true;
                brokenCnt++;
            }
            backTracking(choice+1,eggs,isBroken,brokenCnt);
            eggs[choice][0] = s1;
            eggs[i][0] = s2;
            isBroken[choice] = false;
            isBroken[i] = false;
            brokenCnt = backupCnt;
        }
    }
}

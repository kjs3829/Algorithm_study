// Programmers Level2
// 완전탐색
// 50분 소요
public class 양궁대회_2회차 {
    private final int k = 11;
    private int[] apeach, answer;
    private int maxDiff = 0;

    public int[] solution(int n, int[] info) {
        apeach = info;
        answer = new int[k];
        ex2(new int[k], 0, n);
        if (maxDiff == 0) return new int[]{-1};
        return answer;
    }

    private void ex2(int[] lion, int depth, int n) {
        if (n == 0) {
            int diff = getScoreDiff(lion);
            if (maxDiff < diff) {
                maxDiff = diff;
                for (int i=0; i<k; i++) answer[i] = lion[i];
            } else if (maxDiff == diff) {
                for (int i=k-1; i>=0; i--) {
                    if (lion[i] != answer[i]) {
                        if (lion[i] > answer[i]) {
                            for (int j=0; j<k; j++) answer[j] = lion[j];
                        }
                        break;
                    }
                }
            }
            return;
        }

        for (int i=depth; i<k; i++) {
            lion[i]++;
            ex2(lion, i, n - 1);
            lion[i]--;
        }
    }

    private int getScoreDiff(int[] lion) {
        int a = 0, l = 0;
        for (int i=0; i<k; i++) {
            if (lion[i] > apeach[i]) l += 10-i;
            else if (apeach[i] != 0) a += 10-i;
        }
        return l-a;
    }
}

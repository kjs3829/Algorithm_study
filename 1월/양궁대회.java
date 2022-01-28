// Programmers Level2
// 탐색, 구현
// 1시간 30분 소요
public class 양궁대회 {
    public final int infoLen = 11;
    public int maxAnswer = 0;
    public int[] apeachInfo;
    public int[] answer = new int[infoLen];

    public int[] solution(int n, int[] info) {
        apeachInfo = info;
        bruteForce(new int[infoLen], n, 0);
        if (maxAnswer == 0) return new int[]{-1};
        return answer;
    }

    public void bruteForce(int[] output, int n, int depth) {
        if (n == 0) {
            int lion = 0;
            int apeach = 0;
            for (int i=0; i<infoLen; i++) {
                if (output[i] > apeachInfo[i]) lion += 10-i;
                else if (apeachInfo[i] != 0) apeach += 10-i;
            }

            if (lion > apeach)  {
                if (lion-apeach > maxAnswer) {
                    maxAnswer = lion-apeach;
                    System.arraycopy(output, 0, answer, 0, infoLen);
                } else if (lion-apeach == maxAnswer) {
                    for (int i=infoLen-1; i>=0; i--) {
                        if (output[i]>answer[i]) {
                            System.arraycopy(output, 0, answer, 0, infoLen);
                            break;
                        } else if (output[i] < answer[i]) break;
                    }
                }
            }
            return;
        }

        if (depth == infoLen) return;

        output[depth]++;
        bruteForce(output, n-1, depth);
        output[depth]--;
        bruteForce(output, n, depth+1);
    }
}

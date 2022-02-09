// Programmers Level2
// 진수, 문자열 ,구현
// 34분 소요
public class n진수게임 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int num = 0, idx = 1, next = p;
        boolean isAnswer = false;

        while(!isAnswer) {
            String N = Integer.toString(num++, n).toUpperCase();
            for (int i=0; i<N.length(); i++) {
                if (idx++ == next) {
                    answer.append(N.charAt(i));
                    next += m;
                    if (answer.length() == t) {
                        isAnswer = true;
                        break;
                    }
                }
            }
        }

        return answer.toString();
    }
}

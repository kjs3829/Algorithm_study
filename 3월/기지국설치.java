// Programmers Level3
// 시뮬레이션
// 50분 소요
public class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int end = 0;
        double range = w*2+1;

        for (int station : stations) {
            int startIdx = station-w;
            if (startIdx > end+1)
                answer += Math.ceil(((startIdx)-(end+1))/range);
            end = station+w;
        }

        if (end < n) answer += Math.ceil((n-end)/range);

        return answer;
    }
}

package programmers.kakao.blind2021;

// Programmers Level3
// 누적합
// 실패
// 함수 호출에 시간이 오래 걸린다는 생각을 못함.
// 로직을 함수화하고 30만*36만번 호출되는 반복문 안에서 호출되게 했더니 시간 초과가 뜸
// 검색해본 결과 함수를 호출하게 하지 말고 그냥 해당 로직을 반복문 안에 적었더니 통과됨
public class 광고삽입 {
    public String solution(String play_time, String adv_time, String[] logs) {
        int play_second = convertTime2Second(play_time);
        int adv_second = convertTime2Second(adv_time);

        int[] time = new int[play_second];
        for (String log : logs) {
            String[] s = log.split("-");
            int st = convertTime2Second(s[0]);
            int end = convertTime2Second(s[1]);
            for (int i=st; i<end; i++) time[i]++;
        }

        long sum = 0;
        for (int i=0; i<adv_second; i++) sum += time[i];
        long max = sum, answer = 0;
        for (int i=adv_second; i<play_second; i++) {
            sum += time[i] -time[i-adv_second];
            if (sum > max) {
                max = sum;
                answer = i-adv_second+1;
            }
        }

        long h = answer/3600;
        long m = answer%3600/60;
        long s = answer%3600%60;
        StringBuilder sb = new StringBuilder();
        if (h/10 == 0) sb.append("0");
        sb.append(h).append(":");
        if (m/10 == 0) sb.append("0");
        sb.append(m).append(":");
        if (s/10 == 0) sb.append("0");
        sb.append(s);
        return sb.toString();
    }


    private int convertTime2Second(String time) {
        String[] s = time.split(":");
        return Integer.parseInt(s[0])*60*60+Integer.parseInt(s[1])*60+Integer.parseInt(s[2]);
    }
}

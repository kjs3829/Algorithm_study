// Programmer Level3
// 문자열
// 2시간 30분 소요
public class 백십옮기기 {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i=0; i<s.length; i++) answer[i] = getResult(s[i]);

        return answer;
    }

    private String getResult(String x) {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        int idx = 0, cnt = 0;

        for (int i=0; i<x.length(); i++) {
            char c = x.charAt(i);
            if (c == '0') {
                if (idx > 1 && sb.charAt(idx-1) == '1' && sb.charAt(idx-2) == '1') {
                    sb.delete(idx-2,idx+1);
                    cnt++;
                    idx -= 3;
                }
            }
            idx++;
        }

        idx = sb.length();
        for (int i=sb.length()-1; i>=0; i--) {
            if (sb.charAt(i) == '0') break;
            idx = i;
        }

        for (int i=0; i<cnt; i++) sb.insert(idx, "110");

        return sb.toString();
    }
}

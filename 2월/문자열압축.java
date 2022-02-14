// Programmers Level2
// 문자열
// 40분 소요
public class 문자열압축 {
    public int solution(String s) {
        int answer = s.length();

        for (int i=1; i<=s.length()/2; i++) {
            String zipStr = zip(s, i);
            if (zipStr.length() < answer) answer = zipStr.length();
        }

        return answer;
    }

    private String zip(String s, int unit) {
        StringBuilder sb = new StringBuilder();
        String zipWord = s.substring(0,unit);
        int zipCnt = 1;

        for (int i=1; i<s.length()/unit; i++) {
            String nextWord = s.substring(i*unit,i*unit+unit);
            if (zipWord.equals(nextWord)) zipCnt++;
            else {
                if (zipCnt != 1) sb.append(zipCnt);
                sb.append(zipWord);
                zipWord = nextWord;
                zipCnt = 1;
            }
        }

        if (zipCnt != 1) sb.append(zipCnt);
        sb.append(zipWord);
        if (s.length()%unit != 0) sb.append(s.substring(s.length()-s.length()%unit));

        return sb.toString();
    }
}

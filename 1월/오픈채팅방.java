import java.util.*;

// Programmers Level 2
// 해쉬
// 15분 소요
public class 오픈채팅방 {
    Map<String, String> kakaoDB = new HashMap<>();

    public String[] solution(String[] record) {
        for (String r : record) {
            String[] s = r.split(" ");
            if (s[0].equals("Enter") || s[0].equals("Change")) {
                kakaoDB.put(s[1],s[2]);
            }
        }

        List<String> answerList = new ArrayList<>();
        for (String r : record) {
            StringBuilder sb = new StringBuilder();
            String[] s = r.split(" ");
            if (s[0].equals("Enter"))
                answerList.add(sb.append(kakaoDB.get(s[1])).append("님이 들어왔습니다.").toString());
            else if (s[0].equals("Leave"))
                answerList.add(sb.append(kakaoDB.get(s[1])).append("님이 나갔습니다.").toString());
        }

        String[] answer = new String[answerList.size()];
        for (int i=0; i<answer.length; i++)
            answer[i] = answerList.get(i);
        return answer;
    }
}

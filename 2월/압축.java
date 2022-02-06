import java.util.*;

// Programmers Level2
// 해쉬, 구현
// 47분 소요
public class 압축 {
    public int[] solution(String msg) {
        Map<String,Integer> map = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i=0; i<26; i++) map.put(String.valueOf((char)('A'+i)),i+1);

        int idx = 0;
        while(idx<msg.length()) {
            String a = String.valueOf(msg.charAt(idx));

            while(map.containsKey(a)) {
                idx++;
                if (idx >= msg.length()) break;
                a += String.valueOf(msg.charAt(idx));
            }
            if (map.containsKey(a)) answerList.add(map.get(a));
            else {
                answerList.add(map.get(a.substring(0,a.length()-1)));
                map.put(a,map.size()+1);
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i=0; i<answer.length; i++) answer[i] = answerList.get(i);

        return answer;
    }
}

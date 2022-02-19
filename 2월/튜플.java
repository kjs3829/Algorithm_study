import java.util.*;

// Programmers Level2
// 문자열
// 17분 소요
public class 튜플 {
    public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        String[] tuple = s.replaceAll("},\\{"," ").replaceAll("[}\\{]","").split(" ");
        Arrays.sort(tuple, (s1,s2) -> s1.length()-s2.length());

        int[] answer = new int[tuple.length];
        int idx = 0;
        for (String e : tuple) {
            for (String n : e.split(",")) {
                if (set.add(n)) {
                    answer[idx++] = Integer.parseInt(n);
                    break;
                }
            }
        }

        return answer;
    }
}

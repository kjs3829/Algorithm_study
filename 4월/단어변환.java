import java.util.*;

// Programmers Level3
// 그래프탐색, 너비우선탐색
// 18분 소요
public class 단어변환 {
    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }

    public int bfs(String begin, String target, String[] words) {
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        Map<String,Integer> visit = new HashMap<>();
        visit.put(begin, 0);

        while(!q.isEmpty()) {
            String p = q.poll();
            if (p.equals(target)) return visit.get(p);

            for (int i=0; i<words.length; i++) {
                String nextWord = words[i];
                if (!visit.containsKey(nextWord) && canConvert(p,nextWord)) {
                    q.offer(nextWord);
                    visit.put(nextWord, visit.get(p)+1);
                }
            }
        }

        return 0;
    }

    private boolean canConvert(String A, String B) {
        if (A.equals(B)) return false;

        boolean converted = false;

        for (int i=0; i<A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (!converted) converted = true;
                else return false;
            }
        }

        return true;
    }
}

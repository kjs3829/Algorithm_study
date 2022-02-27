import java.util.*;

// Programmers Level3
// 완전탐색, 비트마스크
// 1시간 소요
public class 불량사용자 {
    private int answer = 0;
    private Set<String> set = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        comb(new boolean[user_id.length], user_id, banned_id, 0, banned_id.length, banned_id.length);
        return answer;
    }

    private void comb(boolean[] visit, String[] user_id, String[] banned_id, int depth, int n, int r) {
        if (r == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<visit.length; i++) {
                if (visit[i]) sb.append(i);
            }
            if (set.add(sb.toString())) answer++;
            return;
        }
        if (depth >= n) return;

        for (int i=0; i< user_id.length; i++) {
            if (!visit[i] && compare(user_id[i], banned_id[depth])) {
                visit[i] = true;
                comb(visit, user_id, banned_id, depth+1, n, r-1);
                visit[i] = false;
            }
        }
    }

    private boolean compare(String uid, String bid) {
        if (uid.length() != bid.length()) return false;

        for (int i=0; i<uid.length(); i++) {
            char b = bid.charAt(i);
            if (b != '*' && b != uid.charAt(i)) return false;
        }

        return true;
    }
}

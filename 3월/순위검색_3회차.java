import java.util.*;

// Programmers Level2
// 문자열, 해쉬, 조합, 이분탐색
// 1시간 10분 소요
public class 순위검색_3회차 {
    private Map<String,List<Integer>> db = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        for (String i : info) {
            for (int r=0; r<5; r++) comb(new boolean[4],i.split(" "), 0, 4, r);
        }

        for (List<Integer> scores : db.values()) Collections.sort(scores);

        int[] answer = new int[query.length];
        for (int i=0; i<query.length; i++) {
            String[] qArr = query[i].replaceAll(" and ", "").split(" ");
            if (db.containsKey(qArr[0])) {
                List<Integer> scores = db.get(qArr[0]);
                answer[i] = lowerBound(scores, Integer.parseInt(qArr[1]));
            } else answer[i] = 0;
        }

        return answer;
    }

    private void comb(boolean[] output, String[] info, int depth, int n, int r) {
        if (r == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<n; i++) {
                if (output[i]) sb.append(info[i]);
                else sb.append("-");
            }
            String key = sb.toString();
            int score = Integer.parseInt(info[4]);
            if (db.containsKey(key)) db.get(key).add(score);
            else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(score);
                db.put(key, tmp);
            }
            return;
        }

        if (depth >= n) return;

        output[depth] = true;
        comb(output, info, depth + 1, n, r - 1);
        output[depth] = false;
        comb(output, info, depth + 1, n, r);
    }

    private int lowerBound(List<Integer> scores, int limitScore) {
        int l=0, r=scores.size()-1;

        while(l<=r) {
            int mid = (l+r)/2;
            if (scores.get(mid)>=limitScore) r = mid - 1;
            else l = mid + 1;
        }

        return scores.size()-(r+1);
    }
}

import java.util.*;

// Programmers Level2
// 조합, 비트마스크, 이분탐색
// 2시간 소요
public class 순위검색_2회차 {
    private Map<String,List<Integer>> db = new HashMap<>();
    private final int n = 4;    //항목 수

    public int[] solution(String[] info, String[] query) {
        insertInfo(info);

        for (String key : db.keySet())
            Collections.sort(db.get(key));

        int[] answer = new int[query.length];
        int idx = 0;

        for (String q : query) {
            String[] splitRq = q.replaceAll(" and ", "").split(" ");
            List<Integer> scoreList = db.get(splitRq[0]);
            int score = Integer.parseInt(splitRq[1]);
            if (db.containsKey(splitRq[0]))
                answer[idx] = scoreList.size() - lowerBound(scoreList, score);
            idx++;
        }

        return answer;
    }

    private void insertInfo(String[] info) {
        for (int r=0; r<=n; r++) {
            comb(info, new boolean[n], 0, r);
        }
    }

    private void comb(String[] info, boolean[] visit, int depth, int r) {
        if (r == 0) {
            for (String in : info) {
                StringBuilder sb = new StringBuilder();
                String[] splitInfo = in.split(" ");
                for (int i=0; i<n; i++) {
                    if (visit[i]) sb.append(splitInfo[i]);
                    else sb.append("-");
                }
                String key = sb.toString();
                int s = Integer.parseInt(splitInfo[n]);
                if (db.containsKey(key)) db.get(key).add(s);
                else db.put(key, new ArrayList<>(Arrays.asList(s)));
            }
            return;
        }
        if (depth >= n) return;

        visit[depth] = true;
        comb(info, visit, depth + 1, r-1);
        visit[depth] = false;
        comb(info, visit, depth + 1, r);
    }

    private int lowerBound(List<Integer> list, int score) {
        int max = list.size()-1;
        int min = 0;
        while (min <= max) {
            int mid = (max+min)/2;
            if (list.get(mid) < score) min = mid+1;
            else max = mid-1;
        }
        return min;
    }
}

import java.util.*;

// Programmers Level2
// 조합, 구현
// 55분 소요
public class 메뉴리뉴얼 {
    public Map<String, Integer> map = new HashMap<>();
    public int maxCnt;

    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();

        for (int c : course) {
            maxCnt = 0;
            for (String order : orders) {
                int cnt = order.length();
                if (cnt >= c) comb(new boolean[cnt],order,c,0);
            }
            if (maxCnt != 1) {
                for (String key : map.keySet()) {
                    if (map.get(key) == maxCnt) answerList.add(key);
                }
            }
            map.clear();
        }
        answerList.sort((o1,o2)->{ return o1.compareTo(o2);});
        String[] answer = new String[answerList.size()];
        for (int i=0; i<answerList.size(); i++) answer[i] = answerList.get(i);
        return answer;
    }

    public void comb(boolean[] visit, String order, int r, int depth) {
        if (r == 0) {
            PriorityQueue<Character> pq = new PriorityQueue<>();
            StringBuilder sb = new StringBuilder();

            for (int i=0; i<visit.length; i++) {
                if (visit[i]) pq.offer(order.charAt(i));
            }
            while(!pq.isEmpty()) sb.append(pq.poll());

            String key = sb.toString();
            int val = map.getOrDefault(key,0)+1;
            maxCnt = Math.max(maxCnt, val);
            map.put(key,val);
            return;
        }

        if (depth >= order.length()) return;

        visit[depth] = true;
        comb(visit, order, r-1, depth+1);
        visit[depth] = false;
        comb(visit, order, r, depth+1);
    }
}

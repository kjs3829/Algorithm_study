package programmers.kakao.blind2021;

import java.util.*;

// Programmers Level2
// 조합, 구현
// 56분 소요
public class 메뉴리뉴얼_3회차 {
    private Map<String,Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        for (int r : course) {
            for (String order : orders) {
                comb(new boolean[order.length()], order, 0, order.length(), r);
            }
        }

        List<String> answerList = new ArrayList<>();
        for (int r : course) {
            List<String> tmp = new ArrayList<>();
            int max = 0;
            for (String order : map.keySet()) {
                if (order.length() != r) continue;
                int orderCnt = map.get(order);
                if (orderCnt == max) tmp.add(order);
                else if (orderCnt > max) {
                    max = orderCnt;
                    tmp.clear();
                    tmp.add(order);
                }
            }
            if (max > 1) {
                for (String o : tmp) answerList.add(o);
            }
        }
        String[] answer = new String[answerList.size()];
        for (int i=0; i<answer.length; i++) answer[i] = answerList.get(i);
        Arrays.sort(answer);
        return answer;
    }

    private void comb(boolean[] visit, String order, int depth, int n, int r) {
        if (r == 0) {
            char[] ch = order.toCharArray();
            Arrays.sort(ch);
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<n; i++) {
                if (visit[i]) sb.append(ch[i]);
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);

            return;
        }

        if (depth >= n) return;

        visit[depth] = true;
        comb(visit, order, depth + 1, n, r - 1);
        visit[depth] = false;
        comb(visit, order, depth + 1, n, r);
    }
}

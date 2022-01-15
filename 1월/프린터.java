import java.util.*;

// Programmers Level2
// 스택,큐
// 36분 소요
public class 프린터 {
    public int solution(int[] priorities, int location) {
        Queue<Integer> pq = new LinkedList<>();
        Queue<Integer> iq = new LinkedList<>();
        for (int i=0; i<priorities.length; i++) {
            pq.offer(priorities[i]);
            iq.offer(i);
        }
        int idx = priorities.length-1;
        Arrays.sort(priorities);
        int answer = 1;
        while(!pq.isEmpty()) {
            int p = pq.poll();
            int i = iq.poll();
            if (p == priorities[idx]) {
                if (i == location) break;
                answer++;
                idx--;
            } else {
                pq.offer(p);
                iq.offer(i);
            }
        }
        return answer;
    }
}

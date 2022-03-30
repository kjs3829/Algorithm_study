import java.util.*;

// Programmers Level3
// 그리디, 우선순위 큐
// 12분 소요
public class 야근지수 {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1,i2)->i2-i1);

        for (int work : works) pq.offer(work);

        for (int i=0; i<n; i++) {
            if (pq.isEmpty()) break;
            int p = pq.poll();
            if (p != 0) pq.offer(p-1);
        }

        long answer = 0;

        while(!pq.isEmpty()) {
            answer += Math.pow(pq.poll(),2);
        }

        return answer;
    }
}

import java.util.*;

// Programmers Level3
// 스케쥴링(SJF) 구현
// 1시간 30분 소요
public class 디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (i1,i2)-> {
            if (i1[0] == i2[0]) return i1[1]-i2[1];
            return i1[0] - i2[0];
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1,i2)-> {
            if (i1[1] == i2[1]) return i1[0]-i2[0];
            return i1[1] - i2[1];
        });

        int idx = 0, endTime = 0;
        while(idx < jobs.length || !pq.isEmpty()) {
            if (pq.isEmpty()) {
                endTime = jobs[idx][0];
                pq.offer(jobs[idx++]);
            }
            int[] p = pq.poll();
            answer += endTime - p[0] + p[1];
            endTime += p[1];
            while(idx < jobs.length && jobs[idx][0] < endTime) {
                pq.offer(jobs[idx++]);
            }
        }


        return answer/jobs.length;
    }
}

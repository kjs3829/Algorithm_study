import java.util.*;

// Programmers Level3
// 다익스트라
// 33분 소요
public class 배달_2회차 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        Map<Integer,Integer>[] adjMapArr = new HashMap[N+1];
        for (int i=1; i<=N; i++) adjMapArr[i] = new HashMap<>();

        for (int[] r : road) {
            if (!adjMapArr[r[0]].containsKey(r[1]) || adjMapArr[r[0]].get(r[1]) > r[2]) {
                adjMapArr[r[0]].put(r[1],r[2]);
                adjMapArr[r[1]].put(r[0],r[2]);
            }
        }

        int[] dijkArr = dijk(1, N, adjMapArr);

        for (int i=1; i<dijkArr.length; i++) if (dijkArr[i]<=K) answer++;

        return answer;
    }

    private int[] dijk(int start, int N, Map<Integer,Integer>[] adjMapArr) {
        int[] dijkArr = new int[N+1];
        for (int i=1; i<=N; i++) dijkArr[i] = Integer.MAX_VALUE;
        dijkArr[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1,i2) -> i1[1]-i2[1]);
        pq.offer(new int[]{start, 0});

        while(!pq.isEmpty()) {
            int[] p = pq.poll();

            if (dijkArr[p[0]] < p[1]) continue;
            for (int adjNodeId : adjMapArr[p[0]].keySet()) {
                int cost = adjMapArr[p[0]].get(adjNodeId)+p[1];
                if (cost < dijkArr[adjNodeId]) {
                    dijkArr[adjNodeId] = cost;
                    pq.offer(new int[]{adjNodeId, dijkArr[adjNodeId]});
                }
            }
        }

        return dijkArr;
    }
}

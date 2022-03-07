import java.util.*;

// Programmers Level2
// 다익스트라
// 40분 소요
public class 배달 {
    private final int inf = Integer.MAX_VALUE;

    public int solution(int N, int[][] road, int K) {
        int[] dijkArr = dijk(N, road);
        int answer = 0;
        for (int i : dijkArr) {
            if (i <= K) answer++;
        }
        return answer;
    }

    private int[] dijk(int N, int[][] road) {
        //인접리스트 초기화
        List<Map<Integer,Integer>> adjList = new ArrayList();
        for(int i=0; i<N; i++) adjList.add(new HashMap<>());
        for(int[] r : road) {
            int a = r[0]-1, b = r[1]-1, c = r[2];
            Map<Integer,Integer> m = adjList.get(a);
            if (m.containsKey(b) && m.get(b) <= c) continue;
            m.put(b,c);
            adjList.get(b).put(a,c);
        }

        int[] dijkArr = new int[N];
        for(int i=0; i<N; i++) dijkArr[i] = inf;
        dijkArr[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1,i2)->i1[1]-i2[1]);
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty()) {
            int[] p = pq.poll();
            if (dijkArr[p[0]] < p[1]) continue;
            Map<Integer,Integer> adjMap = adjList.get(p[0]);
            for (Integer next : adjMap.keySet()) {
                int nc = p[1]+adjMap.get(next);
                if (nc < dijkArr[next]) {
                    dijkArr[next] = nc;
                    pq.offer(new int[]{next, nc});
                }
            }
        }

        return dijkArr;
    }
}

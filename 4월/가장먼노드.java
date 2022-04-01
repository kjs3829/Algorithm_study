import java.util.*;

// Programmers Level3
// 그래프 탐색, 너비우선탐색
// 14분 소요
public class 가장먼노드 {
    public int solution(int n, int[][] edge) {
        List<Integer>[] adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) adjList[i] = new ArrayList<>();
        for(int[] e : edge) {
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }

        return bfs(1, n, adjList);
    }

    private int bfs(int startNode, int n, List<Integer>[] adjList) {
        int max = 0, cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] visit = new int[n+1];
        visit[startNode] = 1;
        q.offer(1);

        while(!q.isEmpty()) {
            int p = q.poll();

            for (int i=0; i<adjList[p].size(); i++) {
                int nextNode = adjList[p].get(i);
                if (visit[nextNode] == 0) {
                    visit[nextNode] = visit[p] + 1;
                    q.offer(nextNode);
                    if (max < visit[nextNode]) {
                        max = visit[nextNode];
                        cnt = 1;
                    } else if (max == visit[nextNode]) cnt++;
                }
            }
        }

        return cnt;
    }
}

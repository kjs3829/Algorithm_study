import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// BOJ 2606 SILVER 3
// 그래프 탐색
public class 바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<=n; i++) adjList.add(new ArrayList<>());
        for (int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        System.out.println(bfs(adjList, n));
    }

    public static int bfs(List<List<Integer>> adjList, int n) {
        Queue<Integer> s = new LinkedList<>();
        boolean[] visit = new boolean[n+1];
        visit[1] = true;
        s.add(1);
        int answer = 0;
        while (!s.isEmpty()) {
            int p = s.poll();
            List<Integer> adjNodes = adjList.get(p);
            for (int i=0; i<adjNodes.size(); i++) {
                Integer adjNode = adjNodes.get(i);
                if (!visit[adjNode]) {
                    s.add(adjNode);
                    visit[adjNode] = true;
                    answer++;
                }
            }
        }
        return answer;
    }
}

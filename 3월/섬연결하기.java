import java.util.*;

// Programmers Level3
// 최소신장트리(MST), 크루스칼 알고리즘, Union&Find
public class 섬연결하기 {
    private int[] parents;

    public int solution(int n, int[][] costs) {
        parents = new int[n];
        for (int i=0; i<n; i++) parents[i] = i;

        Arrays.sort(costs, (i1,i2)->i1[2]-i2[2]);

        int cnt = 0, idx = 0, answer = 0;
        while(cnt < n-1) {
            int[] cost = costs[idx++];
            int p1 = find(cost[0]);
            int p2 = find(cost[1]);
            if (p1 != p2) {
                union(p1,p2);
                answer+=cost[2];
                cnt++;
            }
        }
        return answer;
    }

    private int find(int n) {
        if (parents[n] == n) return n;
        return find(parents[n]);
    }

    private void union(int a, int b) {
        if (a > b) parents[a] = b;
        else parents[b] = a;
    }
}

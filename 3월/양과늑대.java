// Programmers Level3
// 완전탐색
// 1시간 34분 소요
public class 양과늑대 {
    private int[] parent;
    private boolean[] visit;
    private int answer = 0;
    private int n;

    public int solution(int[] info, int[][] edges) {
        n = info.length;
        parent = getParentArray(edges);
        visit = new boolean[n];
        visit[0] = true;
        dfs(info, 0, 0, 0);
        return answer;
    }

    private int[] getParentArray(int[][] edges) {
        int[] p = new int[n];
        for (int[] edge : edges) p[edge[1]] = edge[0];
        return p;
    }

    private void dfs(int[] info, int curIdx, int sheep, int wolf) {
        if (info[curIdx] == 0) sheep += 1;
        else wolf += 1;

        if (wolf >= sheep) return;
        if (answer < sheep) answer = sheep;

        for (int i=1; i<n; i++) {
            if (!visit[i] && visit[parent[i]]) {
                visit[i] = true;
                dfs(info, i, sheep, wolf);
                visit[i] = false;
            }
        }
    }
}

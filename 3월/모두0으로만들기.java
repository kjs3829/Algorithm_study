import java.util.*;

// Programmers Level3
// 그래프 탐색, 그리디, 위상 정렬(사용 안함)
// 1시간 57분 소요
public class 모두0으로만들기 {
    private int nodeCnt;

    public long solution(int[] a, int[][] edges) {
        long answer = 0;
        nodeCnt = a.length;
        long[] A = new long[nodeCnt];
        for (int i=0; i<nodeCnt; i++) A[i] = a[i];

        List<Integer>[] edgeList = new List[nodeCnt];
        for (int i=0; i<nodeCnt; i++) edgeList[i] = new ArrayList<>();
        for (int[] edge : edges) {
            edgeList[edge[0]].add(edge[1]);
            edgeList[edge[1]].add(edge[0]);
        }

        boolean[] visit = new boolean[nodeCnt];
        List<List<Integer>> depthList = getDepthList(0, edgeList);

        for (int d=depthList.size()-1; d>=0; d--) {
            for (Integer ci : depthList.get(d)) {
                visit[ci] = true;

                for (Integer ni : edgeList[ci]) {
                    if (!visit[ni]) {
                        A[ni] += A[ci];
                        answer += Math.abs(A[ci]);
                    }
                }
            }
        }

        if (A[0] != 0) return -1;

        return answer;
    }

    private List<List<Integer>> getDepthList(int startIdx, List<Integer>[] edgeList) {
        List<List<Integer>> depthList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(startIdx);
        int[] depth = new int[nodeCnt];
        depth[startIdx] = 1;

        int nextNodeIdx = 0;
        while(!q.isEmpty()) {
            int p = q.poll();

            for (int i=0; i<edgeList[p].size(); i++) {
                nextNodeIdx = edgeList[p].get(i);
                if (depth[nextNodeIdx] == 0) {
                    q.offer(nextNodeIdx);
                    depth[nextNodeIdx] = depth[p] + 1;
                    if (depthList.size() < depth[nextNodeIdx]-1) depthList.add(new ArrayList<>());
                    depthList.get(depth[nextNodeIdx]-2).add(nextNodeIdx);
                }
            }
        }

        return depthList;
    }
}

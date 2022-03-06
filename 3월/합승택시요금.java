package programmers.kakao.blind2021;

import java.util.*;

// Programmers Level3
// 다익스트라, 플로이드와샬
// 1시간 10분 소요
public class 합승택시요금 {
    private final int inf = Integer.MAX_VALUE;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dijkArr = dijk(n, fares);
        int min = inf;
        for (int i=0; i<n; i++)
            min = Math.min(min, dijkArr[s-1][i]+dijkArr[i][a-1]+dijkArr[i][b-1]);
        return min;
    }

    private int[][] dijk(int n, int[][] fares) {

        //인접리스트 초기화
        List<List<Node>> adjList = new ArrayList<>();
        for (int i=0; i<n; i++) adjList.add(new ArrayList<Node>());
        for (int[] fare : fares) {
            adjList.get(fare[0]-1).add(new Node(fare[1]-1,fare[2]));
            adjList.get(fare[1]-1).add(new Node(fare[0]-1,fare[2]));
        }

        //다익스트라 최단거리배열 초기화
        int[][] dijkArr = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) dijkArr[i][j] = inf;
        }

        for (int i=0; i<n; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2)->Integer.compare(n1.cost,n2.cost));
            pq.offer(new Node(i,0));
            dijkArr[i][i] = 0;

            while(!pq.isEmpty()) {
                Node p = pq.poll();

                if (p.cost > dijkArr[i][p.n]) continue;
                for (Node next : adjList.get(p.n)) {
                    if (dijkArr[i][next.n] > p.cost + next.cost) {
                        dijkArr[i][next.n] = p.cost + next.cost;
                        pq.offer(new Node(next.n,dijkArr[i][next.n]));
                    }

                }
            }
        }

        return dijkArr;
    }

    private class Node {
        int n;
        int cost;

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }
    }
}

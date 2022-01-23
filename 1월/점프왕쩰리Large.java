import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// BOJ 16174 SILVER1
// 그래프 탐색, 다이나믹 프로그래밍
// 18분 소요
public class 점프왕쩰리Large {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        StringTokenizer st;
        for (int r=0; r<n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c=0; c<n; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        if (dfs(n,arr)) System.out.println("HaruHaru");
        else System.out.println("Hing");
    }

    public static boolean dfs(int n, int[][] arr) {
        Stack<int[]> stack = new Stack<>();
        boolean[][] visit = new boolean[n][n];
        visit[0][0] = true;
        stack.add(new int[]{0,0});
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            int r = pop[0];
            int c = pop[1];
            int v = arr[r][c];
            if (v == -1) return true;

            if (c+v<n && !visit[r][c+v]) {
                stack.add(new int[]{r,c+v});
                visit[r][c+v] = true;
            }

            if (r+v<n && !visit[r+v][c]) {
                stack.add(new int[]{r+v,c});
                visit[r+v][c] = true;
            }
        }
        return false;
    }
}

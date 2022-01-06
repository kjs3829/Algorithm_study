import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 15649 SILVER 3
// 백트래킹
public class N과M_1 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        permutation(new int[m], new boolean[n+1], n, m, 0);
        System.out.println(sb);
    }

    public static void permutation(int[] output, boolean[] visit, int n, int r, int depth) {
        if (depth == r) {
            for (int i : output) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                output[depth] = i;
                permutation(output, visit, n, r, depth+1);
                visit[i] = false;
            }
        }
    }
}

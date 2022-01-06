import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 15650 SILVER 3
// 백트래킹
public class N과M_2 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        permutation("",0, n, r);
        System.out.println(sb);
    }

    public static void permutation(String output, int depth, int n, int r) {
        if (r == 0) {
            sb.append(output).append("\n");
            return;
        }
        if (depth >= n) return;

        permutation(output + (depth+1) + " ", depth+1, n, r-1);
        permutation(output, depth+1, n, r);
    }
}

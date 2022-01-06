import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 15651 SILVER 3
// 백트래킹
public class N과M_3 {
    public static StringBuilder sb = new StringBuilder();
    public static int[] output;
    public static int n, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        output = new int[r];
        permutation(0);
        System.out.println(sb);
    }

    public static void permutation(int depth) {
        if (depth == r) {
            for (int i : output)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=1; i<=n; i++) {
            output[depth] = i;
            permutation(depth+1);
        }
    }
}

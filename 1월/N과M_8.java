import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ 15657 SILVER 3
// 백트래킹
public class N과M_8 {
    public static StringBuilder sb = new StringBuilder();
    public static int[] output, arr;
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        output = new int[m];
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        permutation(0, 0);
        System.out.println(sb);
    }

    public static void permutation(int depth, int start) {
        if (depth == m) {
            for (int i : output)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for (int i=start; i<n; i++) {
            output[depth] = arr[i];
            permutation(depth + 1, i);
        }
    }
}

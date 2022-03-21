import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 2900 GOLD5
// 누적합, 정수론
// 1시간 30분 소요
public class 프로그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] calls = new int[n];
        long[] sums = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<k; i++) calls[Integer.parseInt(st.nextToken())]++;

        for (int i=2; i<n; i++) {
            if (calls[i] != 0) {
                for (int j = i; j < n; j += i) {
                    sums[j] += calls[i];
                }
            }
        }

        sums[0] = k;
        sums[1] = calls[1] + k;
        for (int i=2; i<n; i++) sums[i] += sums[i-1] + calls[1];
        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        for (int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int si = Integer.parseInt(st.nextToken());
            int ei = Integer.parseInt(st.nextToken());
            if (si == 0) sb.append(sums[ei]).append("\n");
            else sb.append(sums[ei]-sums[si-1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}

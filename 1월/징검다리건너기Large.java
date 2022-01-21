import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 22871 SILVER1
// DP, 이분탐색
// 1시간 소요
public class 징검다리건너기Large {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        long[] answer = new long[n];
        for (int i=1; i<n; i++) answer[i] = (long) i *(1+Math.abs(arr[i]-arr[0]));
        for (int i=1; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                answer[j] = Math.min(answer[j],Math.max(answer[i], (long) (j - i) *(1+Math.abs(arr[i]-arr[j]))));
            }
        }
        System.out.println(answer[n-1]);
    }
}

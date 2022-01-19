import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 21758 SILVER1
// 그리디, 누적합
// 2시간 소요
public class 꿀따기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sums = new int[n];
        int[] arr = new int[n];
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (max < arr[i]) max = arr[i];
            sum += arr[i];
            sums[i] = sum;
        }

        int answer = 0;
        for (int i=1; i<n-1; i++)
            answer = Math.max(answer, (sums[n-1]-arr[0]-arr[i])+(sums[n-1]-sums[i]));
        for (int i=n-2; i>0; i--)
            answer = Math.max(answer, (sums[n-2]-arr[i])+sums[i-1]);
        answer = Math.max(answer, sums[n-1]-arr[0]-arr[n-1]+max);
        System.out.println(answer);
    }
}

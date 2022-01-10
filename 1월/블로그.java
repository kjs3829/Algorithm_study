import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 21921 SILVER 3
// 투 포인터, 누적합, 슬라이딩 윈도우
public class 블로그 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+x];
        for (int i=0; i<x; i++) arr[i] = 0;
        for (int i=x; i<n+x; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int sum = 0, max = 0, cnt = 0;
        for (int i=x; i<n+x; i++) {
            sum = sum + arr[i] - arr[i-x];
            if (sum > max) {
                max = sum;
                cnt = 1;
            } else if (sum == max) cnt++;
        }
        if (max == 0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}

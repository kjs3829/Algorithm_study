import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 20922 SILVER1
// 투 포인터
// 1시간 7분 소요
public class 겹치는건싫어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] cnt = new int[200001];
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 0, right = 0;
        int answer = 0;
        while(right < n) {
            if (cnt[arr[right]] + 1 > k) {
                while(arr[left] != arr[right]) {
                    cnt[arr[left]]--;
                    left++;
                }
                left++;
            } else {
                cnt[arr[right]]++;
                answer = Math.max(answer, right-left+1);
            }
            right++;
        }
        System.out.println(answer);
    }
}

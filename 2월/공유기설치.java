import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ 2110 GOLD5
// 이분 탐색
// 1시간 소요
public class 공유기설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        System.out.println(binarySearch(arr, c));
    }

    private static int binarySearch(int[] arr, int c) {
        int l = 0;
        int r = 1000000000;
        while(l<=r) {
            int mid = (l+r)/2;
            if (check(arr,mid,c)) l = mid + 1;
            else r = mid - 1;
        }
        return r;
    }

    private static boolean check(int[] arr, int n, int c) {
        int sum = 0;
        int cnt = 1;
        for (int i=1; i<arr.length; i++) {
            sum += arr[i]-arr[i-1];
            if (sum >= n) {
                sum = 0;
                cnt++;
            }
        }
        return cnt >= c;
    }
}

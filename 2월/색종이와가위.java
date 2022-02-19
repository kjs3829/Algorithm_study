import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 20444 Gold5
// 수학, 이분탐색
// 45분 소요
public class 색종이와가위 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        if (binarySearch(n, k)) System.out.println("YES");
        else System.out.println("NO");
    }

    private static boolean binarySearch(long n, long k) {
        long l = 0, r = n;
        while (l <= r) {
            long mid = (l+r)/2;
            long tk = (mid+1)*(n-mid+1);
            if (tk == k) return true;
            else if (tk > k) r = mid - 1;
            else l = mid + 1;
        }
        return (r+1)*(n-r+1) == k;
    }
}

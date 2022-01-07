import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 2805 SILVER 3
//
public class 나무자르기 {
    public static int n, m;
    public static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(binarySearch());
    }

    public static int binarySearch() {
        int left = 1;
        int right = 2000000000;
        int mid;
        while(left<=right) {
            mid = (left+right)/2;
            if (check(mid)) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }

    public static boolean check(int height) {
        int sum = 0;
        for (int tree : trees) {
            if (tree > height) sum += tree-height;
            if (sum >= m) return true;
        }
        return false;
    }
}

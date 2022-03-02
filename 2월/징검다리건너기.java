// Programmers Level3
// 이분 탐색
// 1시간 36분 소요
public class 징검다리건너기 {
    public int solution(int[] stones, int k) {
        int l = 0, r = Integer.MAX_VALUE;

        while(l<=r) {
            int mid = (l+r)/2;
            if (check(mid, stones, k)) l = mid+1;
            else r = mid-1;
        }

        return r;
    }

    private boolean check(int mid, int[] stones, int k) {
        int cnt = 0;

        for (int stone : stones) {
            if (stone < mid) cnt++;
            else cnt = 0;
            if (cnt >= k) return false;
        }

        return true;
    }
}

// Programmers Level3
// 이분탐색
// 50분 소요
public class 입국심사 {
    public long solution(int n, int[] times) {
        return binarySearch(n, times);
    }

    private long binarySearch(int n, int[] times) {
        long l = 0, r = Long.MAX_VALUE;
        while(l<=r) {
            long mid = (l+r)/2;
            if (getN(times, mid) >= n) r = mid - 1;
            else l = mid + 1;
        }
        return r+1;
    }

    private long getN(int[] times, long time) {
        long n = 0;

        for (int i=0; i<times.length; i++) {
            n += time/times[i];
            if (n > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }

        return n;
    }
}

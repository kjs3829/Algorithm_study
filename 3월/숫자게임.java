import java.util.*;

// Programmers Level3
// 정렬, 이분탐색
// 39분 소요
public class 숫자게임 {
    private List<Integer> BList;

    public int solution(int[] A, int[] B) {
        Arrays.sort(B);
        BList = new ArrayList<>();
        for (int b : B) BList.add(b);
        int answer = 0;

        for (int a : A) {
            int lbIdx = upperBound(a);
            if (lbIdx == -1) BList.remove(0);
            else {
                BList.remove(lbIdx);
                answer++;
            }
        }

        return answer;
    }

    private int upperBound(int x) {
        int l = 0, r = BList.size()-1;

        while(l<=r) {
            int mid = (l+r)/2;
            if (BList.get(mid) <= x) l = mid + 1;
            else r = mid - 1;
        }

        if (l == BList.size()) return -1;

        return l;
    }
}

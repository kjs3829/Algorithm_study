import java.util.*;

// Programmers Level3
// 그리디
// 37분 소요
public class 단속카메라 {
    public int solution(int[][] routes) {
        for (int[] route : routes) {
            if (route[0]>route[1]) {
                int tmp = route[0];
                route[0] = route[1];
                route[1] = tmp;
            }
        }

        int carCnt = routes.length;
        Arrays.sort(routes, (i1,i2)->{
            if (i1[1]==i2[1]) return i1[0]-i2[0];
            return i1[1]-i2[1];
        });

        int answer = 0, idx = 0;
        while(idx < carCnt) {
            int nextIdx = idx+1;
            while(nextIdx < carCnt && routes[nextIdx][0] <= routes[idx][1]) {
                nextIdx++;
            }
            idx = nextIdx;
            answer++;
        }

        return answer;
    }
}

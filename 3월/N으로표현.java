import java.util.*;

// Programmers Level3
// DP
// 1시간 18분 소요
public class N으로표현 {
    public int solution(int N, int number) {
        if (N == number) return 1;

        Set<Integer>[] dp = new HashSet[9];
        int sp = N;
        for (int i=1; i<9; i++) {
            dp[i] = new HashSet<>();
            dp[i].add(sp);
            sp = sp * 10 + N;
        }
        dp[1].add(N);

        for (int n=2; n<=8; n++) {
            Set<Integer> nextSet = dp[n];

            for (int i=1; i<=n-1; i++) {
                for (Integer first : dp[i]) {
                    for (Integer second : dp[n-i]) {
                        nextSet.add(first+second);
                        nextSet.add(first-second);
                        nextSet.add(second-first);
                        nextSet.add(first*second);
                        if (second != 0) nextSet.add(first/second);
                        if (first != 0) nextSet.add(second/first);
                    }
                }
                if (nextSet.contains(number)) return n;
            }
        }

        return -1;
    }
}

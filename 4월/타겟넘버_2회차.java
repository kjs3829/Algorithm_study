// Programmers Level2
// dfs,bfs
// 7분 소요
public class 타겟넘버_2회차 {
    private int answer = 0;
    private int n;

    public int solution(int[] numbers, int target) {
        n = numbers.length;
        dfs(0, numbers, 0, target);

        return answer;
    }

    private void dfs(int sum, int[] numbers, int depth,int target) {
        if (depth == n) {
            if (sum == target) answer++;
            return;
        }

        dfs(sum+numbers[depth], numbers, depth+1, target);
        dfs(sum-numbers[depth], numbers, depth+1, target);
    }
}

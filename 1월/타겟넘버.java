// Programmers Level2
// 완전탐색
// 5분 소요
public class 타겟넘버 {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        backTracking(0,0,numbers,target);
        return answer;
    }

    public void backTracking(int sum, int depth, int[] numbers, int target) {
        if (depth >= numbers.length) {
            if (sum == target) answer++;
            return;
        }
        backTracking(sum+numbers[depth],depth+1,numbers,target);
        backTracking(sum-numbers[depth],depth+1,numbers,target);
    }
}

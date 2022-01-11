import java.util.*;

// Programmers Level 2
// 스택, 큐
// 15분 소요
public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        int len = progresses.length;
        int[] arr = new int[len];
        for (int i=0; i<len; i++)
            arr[i] = (int)Math.ceil((100.0-progresses[i])/speeds[i]);

        int before = arr[0];
        int cnt = 1;
        for (int i=1; i<len; i++) {
            if (arr[i] > before) {
                answerList.add(cnt);
                cnt = 1;
                before = arr[i];
            }
            else cnt++;
        }
        answerList.add(cnt);

        int[] answer = new int[answerList.size()];
        for(int i=0; i<answer.length; i++)
            answer[i] = answerList.get(i);
        return answer;
    }
}

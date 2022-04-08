import java.util.*;

// Programmers Level3
// 자료구조(Heap,Set)
// 1시간 5분 소요
public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((i1,i2) -> i2-i1);
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        int cnt = 0;

        for (String op : operations) {
            String[] o = op.split(" ");
            if (o[0].equals("I")) {
                maxQ.offer(Integer.parseInt(o[1]));
                minQ.offer(Integer.parseInt(o[1]));
                cnt++;
            } else if (cnt > 0) {
                if (o[1].equals("1")) {
                    maxQ.poll();
                    cnt--;
                } else if (o[1].equals("-1")) {
                    minQ.poll();
                    cnt--;
                }
                if (cnt == 0) {
                    maxQ.clear();
                    minQ.clear();
                }
            }
        }

        int max = maxQ.peek() == null ? 0 : maxQ.poll();
        int min = minQ.peek() == null ? 0 : minQ.poll();

        return new int[]{max, min};
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// BOJ 1715 GOLD5
// 그리디, 우선순위 큐
// 11분 소요
public class 카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<n; i++) pq.offer(Integer.parseInt(br.readLine()));
        int sum = 0;
        while (pq.size() > 1) {
            int s = pq.poll()+pq.poll();
            sum += s;
            pq.offer(s);
        }
        System.out.println(sum);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// BOJ 2493 GOLD5
// 자료구조, 스택
// 1시간 10분 소요
public class 탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] towers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) towers[i] = Integer.parseInt(st.nextToken());
        Stack<int[]> stack = new Stack<>();
        int[] answer = new int[n];

        for (int idx=n-1; idx>=0; idx--) {
            int next = towers[idx];
            while(!stack.isEmpty() && stack.peek()[0] <= next) {
                int pidx = stack.pop()[1];
                answer[pidx] = idx+1;
            }
            stack.add(new int[]{next,idx});
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) sb.append(i).append(" ");

        System.out.println(sb.toString());
    }
}

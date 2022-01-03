package solved.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// BOJ 1874 SILVER 3
// 자료 구조, 스택
public class Main {
    public static int n;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i=0; i<n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        getResult();
    }

    public static void getResult() {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int inc = 1;
        int idx = 0;
        while (idx < n) {
            while (inc <= arr[idx]) {
                stack.add(inc++);
                sb.append("+").append("\n");
            }
            if (stack.pop() != arr[idx]) {
                System.out.println("NO");
                return;
            }
            sb.append("-").append("\n");
            idx++;
        }
        System.out.println(sb);
    }
}

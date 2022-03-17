import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// BOJ 1990 GOLD5
// 수학, 정수론, 소수 판정, 구현
// 46분 소요
public class 소수인팰린드롬 {
    private static List<Integer> primedPalindromeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        for (int i=1; i<10; i++) {
            if (i%2==0) makePalindrome("",i/2);
            else {
                for (int j=0; j<10; j++) {
                    makePalindrome(String.valueOf(j),i/2);
                }
            }
        }
        Collections.sort(primedPalindromeList);
        StringBuilder sb = new StringBuilder();
        int idx = 0, primedPalindrome = primedPalindromeList.get(idx);
        while (primedPalindrome <= b) {
            if (primedPalindrome >= a) sb.append(primedPalindrome).append("\n");
            primedPalindrome = primedPalindromeList.get(idx++);
        }
        System.out.println(sb.append(-1).toString());
    }

    private static void makePalindrome(String output, int depth) {
        if (depth == 0) {
            int palindrome = Integer.parseInt(output);
            if (isPrime(palindrome))
                primedPalindromeList.add(palindrome);
            return;
        }

        for (int i=(depth == 1 ? 1 : 0); i<10; i++)
            makePalindrome(i+output+i, depth - 1);

    }

    private static boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        for (int i=2; i<=Math.sqrt(n); i++) {
            if (n%i==0) return false;
        }
        return true;
    }
}

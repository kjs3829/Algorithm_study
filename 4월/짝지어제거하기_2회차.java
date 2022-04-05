import java.util.*;

// Programmers Level2
// 자료구조(스택)
// 6분 소요
public class 짝지어제거하기_2회차 {
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);
        }

        return stack.isEmpty() ? 1 : 0;
    }
}

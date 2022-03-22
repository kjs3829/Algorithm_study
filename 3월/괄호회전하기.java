import java.util.*;

// Programmers Level2
// 문자열, 스택
// 15분 소요
public class 괄호회전하기 {
    public int solution(String s) {
        int answer = 0;

        for (int i=0; i<s.length(); i++) {
            String tmp = s.substring(i) + s.substring(0,i);
            if (isCorrect(tmp)) answer++;
        }
        return answer;
    }

    private boolean isCorrect(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (stack.isEmpty()) {
                if (c == '}' || c == ']' || c == ')') return false;
                else stack.push(c);
            } else {
                if (c == '}') {
                    if (stack.peek() == '{') stack.pop();
                    else return false;
                } else if (c == ']') {
                    if (stack.peek() == '[') stack.pop();
                    else return false;
                } else if (c == ')') {
                    if (stack.peek() == '(') stack.pop();
                    else return false;
                } else stack.push(c);
            }

        }

        return stack.isEmpty();
    }
}

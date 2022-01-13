import java.util.*;

// Programmers Level 2
// 구현
// 19분 소요
public class 괄호변환 {
    private StringBuilder sb = new StringBuilder();

    public String solution(String p) {
        re(p);
        return sb.toString();
    }

    private void re(String p) {
        if (p.equals("")) return;
        String[] s = split(p);
        String u = s[0], v = s[1];
        if (check(u)) {
            sb.append(u);
            re(v);
        }
        else {
            sb.append("(");
            re(v);
            sb.append(")");
            for (int i=1; i<u.length()-1; i++) {
                if (u.charAt(i) == '(') sb.append(")");
                else sb.append("(");
            }
        }
    }

    private String[] split(String w) {
        String[] result = new String[2];
        int l=0,r=0;
        for (int i=0; i<w.length(); i++) {
            if (w.charAt(i) == '(') l++;
            else r++;
            if (l == r) {
                result[0] = w.substring(0,i+1);
                result[1] = w.substring(i+1);
                break;
            }
        }
        return result;
    }

    private boolean check(String u) {
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        while(idx < u.length()) {
            char c = u.charAt(idx++);
            if (c == '(') stack.add(c);
            else if (!stack.isEmpty() && stack.pop() != '(') return false;
        }
        return stack.isEmpty();
    }
}

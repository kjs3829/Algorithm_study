import java.util.*;

// Programmers Level2
// 문자열, 자료구조, 구현
// 1시간 35분 소요
class 수식최대화 {
    private static final int operCnt = 3;
    private static final String[] operations = new String[]{"-","+","*"};
    private long answer = 0;

    public long solution(String expression) {
        List<String> exList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                exList.add(sb.toString());
                exList.add(String.valueOf(c));
                sb = new StringBuilder();
            } else sb.append(c);
        }
        exList.add(sb.toString());
        perm(exList, new boolean[operCnt], 0);
        return answer;
    }

    private void perm(List<String> exList, boolean[] visit, int depth) {
        if (depth == operCnt) {
            answer = Math.max(answer, Math.abs(Long.parseLong(exList.get(0))));
            return;
        }

        for (int i=0; i<operCnt; i++) {
            if (!visit[i]) {
                visit[i] = true;
                perm(cal(exList, operations[i]), visit, depth + 1);
                visit[i] = false;
            }
        }
    }

    private List<String> cal(List<String> expressionList, String operation) {
        List<String> exList = new ArrayList<>(expressionList);
        int idx = 0;
        while(idx < exList.size()) {
            if (exList.get(idx).equals(operation)) {
                exList.set(idx-1,cal2(Long.parseLong(exList.get(idx-1)),Long.parseLong(exList.get(idx+1)), operation));
                exList.remove(idx);
                exList.remove(idx);
            } else idx++;
        }
        return exList;
    }

    private String cal2(Long l1, Long l2, String operation) {
        Long result;
        if (operation.equals("-")) result = l1-l2;
        else if (operation.equals("+")) result = l1+l2;
        else result = l1*l2;
        return String.valueOf(result);
    }
}
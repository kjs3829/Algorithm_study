// Programmers Level2
// 순열
// 40분 소요
public class 단체사진찍기_2회차 {
    private String s = "ACFJMNRT";
    private int answer = 0;

    public int solution(int n, String[] data) {
        permutation(new int[8], new boolean[8], 0, data);
        return answer;
    }

    public void permutation(int[] output, boolean[] visit, int depth, String[] data) {
        if (depth == 8) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<output.length; i++)
                sb.append(s.charAt(output[i]));
            if (check(sb.toString(), data)) answer++;
            return;
        }

        for (int i=0; i<8; i++) {
            if (!visit[i]) {
                visit[i] = true;
                output[depth] = i;
                permutation(output, visit, depth+1, data);
                visit[i] = false;
            }
        }
    }

    private boolean check(String pe, String[] data) {
        for (String d : data) {
            char p1 = d.charAt(0);
            char p2 = d.charAt(2);
            char op = d.charAt(3);
            int interval = Integer.parseInt(String.valueOf(d.charAt(4)));
            int realInterval = Math.abs(pe.indexOf(p1) - pe.indexOf(p2)) - 1;
            if (op == '=' && realInterval != interval) return false;
            else if (op == '<' && realInterval >= interval) return false;
            else if (op == '>' && realInterval <= interval) return false;
        }

        return true;
    }
}

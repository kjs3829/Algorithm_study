import java.util.*;

// Programmers Level2
// 조합
// 1시간 10분 소요
public class 후보키 {
    List<String> minCheckList = new ArrayList<>();

    public int solution(String[][] relation) {
        int n = relation[0].length;
        for (int r=1; r<=n; r++) {
            comb(new boolean[n], relation, 0, n, r);
        }

        return minCheckList.size();
    }

    public void comb(boolean[] visit, String[][] relation, int depth, int n, int r) {
        if (r == 0) {
            Set<String> dupCheckSet = new HashSet<>();
            StringBuilder keyIdxBuilder = new StringBuilder();
            for (int i=0; i<n; i++) {
                if (visit[i]) keyIdxBuilder.append(i);
            }

            for (int i=0; i<relation.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j=0; j<n; j++) {
                    if (visit[j]) sb.append(relation[i][j]).append(" ");
                }
                if (!dupCheckSet.add(sb.toString())) return;
            }

            for (String keyIdx : minCheckList) {
                int cnt = 0;
                for (int i=0; i<keyIdx.length(); i++) {
                    if (keyIdxBuilder.indexOf(String.valueOf(keyIdx.charAt(i))) != -1) cnt++;
                }
                if (cnt == keyIdx.length()) return;
            }
            minCheckList.add(keyIdxBuilder.toString());

            return;
        }

        if (depth >= n) return;

        visit[depth] = true;
        comb(visit, relation, depth+1, n, r-1);
        visit[depth] = false;
        comb(visit, relation, depth+1, n, r);
    }
}

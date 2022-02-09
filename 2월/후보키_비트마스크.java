import java.util.*;

// Programmers Level2
// 비트마스크
// 1시간 5분 소요
public class 후보키_비트마스크 {
    private int row, col;
    private Set<String> dupCheckSet;

    public int solution(String[][] relation) {
        List<Integer> answerList = new ArrayList<>();
        row = relation.length;
        col = relation[0].length;
        int max = (int) Math.pow(2,col);

        for (int i=0; i<max; i++) {
            StringBuilder bitmaskBuilder = new StringBuilder(Integer.toString(i,2));
            for (int j=bitmaskBuilder.length(); j<col; j++) bitmaskBuilder.insert(0,0);
            String bitmaskStr = bitmaskBuilder.toString();

            if (uniquenessCheck(relation, bitmaskStr)
                    && minimalityCheck(answerList, i)) answerList.add(i);
        }

        return answerList.size();
    }

    private boolean uniquenessCheck(String[][] relation, String bitmaskStr) {
        dupCheckSet = new HashSet();

        for (int r=0; r<row; r++) {
            StringBuilder keyCombBuilder = new StringBuilder();
            for (int c=0; c<col; c++) {
                if (bitmaskStr.charAt(c) == '1') {
                    keyCombBuilder.append(relation[r][c]).append(" ");
                }
            }
            if (!dupCheckSet.add(keyCombBuilder.toString())) return false;
        }

        return true;
    }

    private boolean minimalityCheck(List<Integer> answerList, int bitmask) {
        for (Integer candiKeyBitmask : answerList) {
            if ((candiKeyBitmask&bitmask) == candiKeyBitmask) return false;
        }
        return true;
    }
}

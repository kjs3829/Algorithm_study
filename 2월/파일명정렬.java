import java.util.*;

// Programmers Level2
// 정렬
// 1시간 소요
public class 파일명정렬 {
    public String[] solution(String[] files) {
        Comparator<String> c = (s1, s2) -> {
            String h1 = getHead(s1);
            String h2 = getHead(s2);
            if (h1.equals(h2)) {
                return getNumber(s1, h1.length())-getNumber(s2, h2.length());
            } else return h1.compareTo(h2);
        };

        Arrays.sort(files, c);
        return files;
    }

    private String getHead(String fileName) {
        int idx;
        for (idx = 0; idx<fileName.length(); idx++) {
            if (Character.isDigit(fileName.charAt(idx))) break;
        }
        return fileName.substring(0,idx).toLowerCase();
    }

    private int getNumber(String fileName, int headLen) {
        int idx;
        for (idx = headLen; idx<fileName.length(); idx++) {
            if (!Character.isDigit(fileName.charAt(idx))) break;
        }
        return Integer.parseInt(fileName.substring(headLen, idx));
    }
}

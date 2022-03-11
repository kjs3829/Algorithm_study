import java.util.*;

// Programmers Level2
// 문자열, 정렬
// 18분 소요
public class 파일명정렬_2회차 {
    public String[] solution(String[] files) {
        File[] result = new File[files.length];
        int idx = 0;
        for (String file : files) result[idx++] = new File(file);
        Arrays.sort(result, (f1,f2) -> {
            if (f1.head.equals(f2.head))
                return Integer.parseInt(f1.number)-Integer.parseInt(f2.number);
            return f1.head.compareTo(f2.head);
        });
        idx = 0;
        String[] answer = new String[result.length];
        for (File file : result) answer[idx++] = file.name;
        return answer;
    }

    private class File {
        String name, head, number, tail;

        public File(String fileName) {
            this.name = fileName;
            fileName = fileName.toLowerCase();
            int numberIdx = 0;
            for (int i=0; i<fileName.length(); i++) {
                if (Character.isDigit(fileName.charAt(i))) {
                    this.head = fileName.substring(0,i);
                    numberIdx = i;
                    break;
                }
            }
            int tailIdx = -1;
            for (int i=numberIdx; i<fileName.length(); i++) {
                if (!Character.isDigit(fileName.charAt(i))) {
                    tailIdx = i;
                    break;
                }
            }
            if (tailIdx == -1) {
                this.number = fileName.substring(numberIdx);
                this.tail = "";
            } else {
                this.number = fileName.substring(numberIdx, tailIdx);
                this.tail = fileName.substring(tailIdx);
            }
        }
    }
}

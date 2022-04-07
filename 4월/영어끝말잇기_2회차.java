import java.util.*;

// Programmers Level2
// 해쉬
// 7분 소요
public class 영어끝말잇기_2회차 {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        char lastAlphabet = words[0].charAt(0);

        for (int i=0; i<words.length; i++) {
            if (set.contains(words[i]) || words[i].charAt(0) != lastAlphabet)
                return new int[]{i%n+1, i/n+1};
            lastAlphabet = words[i].charAt(words[i].length()-1);
            set.add(words[i]);
        }

        return new int[2];
    }
}

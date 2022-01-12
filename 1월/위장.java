import java.util.*;

// Programmers Level 2
// 해쉬
// 20분 소요
public class 위장 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> map = new HashMap<>();

        for (String[] clothe : clothes)
            map.put(clothe[1],map.getOrDefault(clothe[1],1)+1);

        for (String Key : map.keySet())
            answer *= map.get(Key);

        return answer-1;
    }
}

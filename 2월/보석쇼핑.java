import java.util.*;

// Programmers Level3
// 자료 구조, 해쉬, 정렬
// 1시간 2분 소요
// IDE 사용 (LinkedHashMap 사용법이 익숙하지 않음)
public class 보석쇼핑 {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        int n = set.size();

        Map<String,Integer> map = new LinkedHashMap<>();
        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];
        for (int i=0; i<gems.length; i++) {
            map.remove(gems[i]);
            map.put(gems[i],i);
            if (map.size() == n) {
                int l = map.get(map.keySet().iterator().next());
                if (i-l < minLen) {
                    minLen = i-l;
                    answer = new int[]{l+1,i+1};
                }
            }
        }

        return answer;
    }
}

import java.util.*;

// Programmers Level2
// 해쉬
// 32분 소요
public class 뉴스클러스터링_3회차 {
    public int solution(String str1, String str2) {
        char[] str1Arr = str1.toUpperCase().toCharArray();
        char[] str2Arr = str2.toUpperCase().toCharArray();
        return getZaccard(makeMultiSet(str1Arr), makeMultiSet(str2Arr));
    }

    private Map<String,Integer> makeMultiSet(char[] strArr) {
        Map<String,Integer> map = new HashMap<>();

        for (int i=0; i<strArr.length-1; i++) {
            if ('A'<=strArr[i] && strArr[i]<='Z' && 'A'<=strArr[i+1] && strArr[i+1]<='Z') {
                String key = ""+strArr[i]+strArr[i+1];
                map.put(key, map.getOrDefault(key,0)+1);
            }
        }

        return map;
    }

    private int getZaccard(Map<String,Integer> map1, Map<String,Integer> map2) {
        double intersection = 0;
        double union = 0;

        for (String key : map1.keySet()) {
            int cnt1 = map1.get(key);
            if (map2.containsKey(key)) {
                int cnt2 = map2.get(key);
                intersection += Math.min(cnt1, cnt2);
                union += Math.max(cnt1, cnt2);
            } else union += cnt1;
        }

        for (String key : map2.keySet()) {
            if (!map1.containsKey(key)) union += map2.get(key);
        }

        return union == 0 ? 65536 : (int)Math.floor(intersection/union*65536);
    }
}

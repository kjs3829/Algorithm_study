import java.util.*;

// Programmers Level2
// 해쉬, 구현
// 56분 소요
public class 뉴스클러스터링 {
    public int solution(String str1, String str2) {
        String preprocessedStr1 = dataPreprocessing(str1);
        String preprocessedStr2 = dataPreprocessing(str2);
        Map<String,Integer> multiset1 = makeMultiset(preprocessedStr1);
        Map<String,Integer> multiset2 = makeMultiset(preprocessedStr2);
        return (int)Math.floor(getJaccardCoefficient(multiset1, multiset2)*65536);
    }

    public String dataPreprocessing(String str) {
        return str.toLowerCase().replaceAll("[^a-z]"," ");
    }

    public Map<String,Integer> makeMultiset(String preprocessedStr) {
        Map<String,Integer> multiset = new HashMap<>();

        for (int i=0; i<preprocessedStr.length()-1; i++) {
            if (preprocessedStr.charAt(i) != ' ' && preprocessedStr.charAt(i+1) != ' ') {
                String e = preprocessedStr.substring(i,i+2);
                multiset.put(e, multiset.getOrDefault(e,0)+1);
            }
        }

        return multiset;
    }

    public double getJaccardCoefficient(Map<String,Integer> multiset1, Map<String,Integer> multiset2) {
        double intersectionCount = 0, unionCount = 0;

        for (String key : multiset1.keySet()) {
            if (multiset2.containsKey(key)) {
                intersectionCount += Math.min(multiset1.get(key), multiset2.get(key));
                unionCount += Math.max(multiset1.get(key), multiset2.get(key));
            }
            else unionCount += multiset1.get(key);
        }

        for (String key : multiset2.keySet()) {
            if (!multiset1.containsKey(key)) unionCount += multiset2.get(key);
        }

        return unionCount == 0 ? 1 : intersectionCount/unionCount;
    }
}

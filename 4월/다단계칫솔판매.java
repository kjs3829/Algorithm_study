import java.util.*;

// Programmers Level3
// 그래프탐색, 구현
// 43분 소요
public class 다단계칫솔판매 {
    private final static int TOOTHBRUSH_COST = 100;
    private Map<String,Integer> empIdxMap = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int empCnt = enroll.length;
        for (int i=0; i<empCnt; i++) empIdxMap.put(enroll[i], i);

        int[] adjList = new int[empCnt];
        for (int i=0; i<empCnt; i++) {
            String re = referral[i];
            if (re.equals("-")) adjList[i] = -1;
            else adjList[i] = empIdxMap.get(re);
        }

        int[] result = new int[enroll.length];

        for (int i=0; i<seller.length; i++) {
            sell(seller[i], amount[i], adjList, result);
        }
        return result;
    }

    private void sell(String seller, int amount, int[] adjList, int[] result) {
        int sellerIdx = empIdxMap.get(seller);
        int income = amount * TOOTHBRUSH_COST;
        while(true) {
            if (sellerIdx == -1) return;
            int recommenderIdx = adjList[sellerIdx];
            int pee = (int)(income*0.1);
            if (pee < 1) {
                result[sellerIdx] += income;
                return;
            }
            result[sellerIdx] += income-pee;
            income = pee;
            sellerIdx = recommenderIdx;
        }
    }
}

// Programmers Level2
// 완전탐색
// 15분 소요
public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int blockCnt = brown+yellow;

        for (int i=3; i<=blockCnt/2; i++) {
            if (blockCnt%i == 0 && (i*2)+(blockCnt/i*2)-4 == brown)
                return new int[]{blockCnt/i,i};
        }

        return null;
    }
}

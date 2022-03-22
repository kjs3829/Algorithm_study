// Programmers Level2
// 문자열
// 25분 소요
public class 두개이하로다른비트_2회차 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int idx = 0;

        for (long number : numbers)
            answer[idx++] = f(number);

        return answer;
    }

    private long f(long x) {
        char[] binaryX = Long.toBinaryString(x).toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i=binaryX.length-1; i >= 0; i--) {
            if (binaryX[i] == '0') {
                if (i != binaryX.length-1) binaryX[i+1] = '0';
                binaryX[i] = '1';
                return Long.parseLong(String.valueOf(binaryX),2);
            }
        }

        sb.append("10").append(String.valueOf(binaryX).substring(1));
        return Long.parseLong(sb.toString(),2);
    }
}

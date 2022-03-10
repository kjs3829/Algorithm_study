import java.util.*;

// Programmers Level2
// 해쉬, 구현
// 46분 소요
public class 주차요금계산_2회차 {
    private Map<String,Integer> enterMinute = new HashMap<>();
    private Map<String,Integer> parkingMinuteMap = new TreeMap<>();
    private final static int endMinute = 1439;

    public int[] solution(int[] fees, String[] records) {
        for (String record : records) {
            String[] tni = record.split(" ");
            int minute = time2minute(tni[0]);
            String carNum = tni[1], state = tni[2];
            if (state.equals("IN")) {
                enterMinute.put(carNum, minute);
            } else if (state.equals("OUT")) {
                parkingMinuteMap.put(carNum,
                        parkingMinuteMap.getOrDefault(carNum,0)+(minute-enterMinute.get(carNum)));
                enterMinute.remove(carNum);
            }
        }

        for (String carNum : enterMinute.keySet()) {
            parkingMinuteMap.put(carNum,
                    parkingMinuteMap.getOrDefault(carNum,0)+(endMinute-enterMinute.get(carNum)));
        }

        int[] answer = new int[parkingMinuteMap.size()];
        int idx = 0;
        for (String carNum : parkingMinuteMap.keySet())
            answer[idx++] = getFee(fees, parkingMinuteMap.get(carNum));
        return answer;
    }

    private int getFee(int[] fees, int parkingMinute) {
        if (fees[0] >= parkingMinute) return fees[1];
        return fees[1]+(int)(Math.ceil(((float)(parkingMinute-fees[0])/(float)fees[2]))*fees[3]);
    }

    private int time2minute(String time) {
        String[] hm = time.split(":");
        return Integer.parseInt(hm[0])*60+Integer.parseInt(hm[1]);
    }
}

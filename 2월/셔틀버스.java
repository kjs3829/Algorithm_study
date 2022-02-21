import java.util.*;

// Programmers Level3
// 구현
// 40분 소요
public class 셔틀버스 {
    private final int firstBusTime = 540;

    public String solution(int n, int t, int m, String[] timetable) {
        int pn = timetable.length;
        int[] timeArr = convertTimeToMinute(pn, timetable);
        Arrays.sort(timeArr);
        int[][] passengerInfo = new int[n][m];
        int idx=0, busTime = firstBusTime;
        for (int i=0; i<n; i++) {
            int inCnt = 0;
            while(inCnt<m && idx<pn && timeArr[idx] <= busTime)
                passengerInfo[i][inCnt++] = timeArr[idx++];
            busTime += t;
        }
        if (passengerInfo[n-1][m-1] != 0) {
            return convertMinuteToTime(passengerInfo[n-1][m-1]-1);
        } else return convertMinuteToTime(busTime-t);
    }

    private int[] convertTimeToMinute(int pn, String[] timetable) {
        int[] arr = new int[pn];
        for (int i=0; i<pn; i++) {
            String[] hm = timetable[i].split(":");
            arr[i] = Integer.parseInt(hm[0])*60+Integer.parseInt(hm[1]);
        }
        return arr;
    }

    private String convertMinuteToTime(int minute) {
        StringBuilder sb = new StringBuilder();
        int h = minute/60;
        int m = minute%60;
        if (h < 10) sb.append("0");
        sb.append(h).append(":");
        if (m < 10) sb.append("0");
        sb.append(m);
        return sb.toString();
    }
}

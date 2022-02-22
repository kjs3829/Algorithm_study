package programmers.kakao.blind2018;

import java.util.*;

// Programmers Level3
// 구현
// 1시간 52분 소요
public class 추석트래픽 {
    public int solution(String[] lines) {
        int answer = 0;
        int[][] co = convert(lines);
        Arrays.sort(co,(i1,i2)->i1[0]-i2[0]);

        for (int r=0; r<lines.length; r++) {
            for (int st=co[r][0]; st<=co[r][1]; st++) {
                int ft = st+999, cnt = 0;
                for (int i=r; i<lines.length; i++) {
                    if (co[i][0]<st) {
                        if (co[i][1] >= st) cnt++;
                    } else if (co[i][0] <= ft) cnt++;
                }
                if (answer < cnt) answer = cnt;
            }
        }

        return answer;
    }

    private int[][] convert(String[] lines) {
        int logCnt = lines.length;
        int[][] startEnd = new int[logCnt][2];  //[[start,end],...]

        for (int i=0; i<logCnt; i++) {
            String[] DST = lines[i].split(" "); //[Day,S,T]
            int T = (int)(Double.parseDouble(DST[2].replace("s",""))*1000);
            String[] time = DST[1].split(":");
            startEnd[i][1] = (int)(((Integer.parseInt(time[0])*60+Integer.parseInt(time[1]))*60+Double.parseDouble(time[2]))*1000);
            startEnd[i][0] = startEnd[i][1] - T + 1;
        }

        return startEnd;
    }
}

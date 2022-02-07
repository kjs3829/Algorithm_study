// Programmers Level2
// 문자열, 구현
// 32분 소요
public class 방금그곡 {
    public String solution(String m, String[] musicinfos) {
        int[] answer = new int[2];  //[idx, runningTime]
        String convertedM = convertSharp(m);
        for (int i=0; i<musicinfos.length; i++) {
            String[] s = musicinfos[i].split(",");
            int runningTime = getRunningTime(s[0].split(":"), s[1].split(":"));
            String convertedMusic = convertSharp(s[3]);
            String replayedMusic = replay(convertedMusic, runningTime);
            if (replayedMusic.contains(convertedM) && answer[1] < runningTime)
                answer = new int[]{i,runningTime};
        }
        if (answer[1] == 0) return "(None)";
        return musicinfos[answer[0]].split(",")[2];
    }

    public int getRunningTime(String[] startTime, String[] endTime) {
        int sh = Integer.parseInt(startTime[0]), sm = Integer.parseInt(startTime[1]);
        int eh = Integer.parseInt(endTime[0]), em = Integer.parseInt(endTime[1]);
        if (em >= sm) return (eh-sh)*60+em-sm;
        else return (eh-1-sh)*60+(em+60-sm);
    }

    public String convertSharp(String music) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<music.length(); i++) {
            char c = music.charAt(i);
            if (c == '#') continue;
            if (i != music.length()-1 && music.charAt(i+1) == '#') sb.append(String.valueOf(c).toLowerCase());
            else sb.append(music.charAt(i));
        }
        return sb.toString();
    }

    public String replay(String music, int runningTime) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<runningTime; i++) sb.append(music.charAt(i%music.length()));
        return sb.toString();
    }
}

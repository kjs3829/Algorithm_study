import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// BOJ 15787 SILVER2
// 구현, 비트마스킹
// 22분 소요
public class 기차가어둠을헤치고은하수를 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<String>[] trains = new ArrayList[n];
        for (int i=0; i<n; i++) {
            trains[i] = new ArrayList<>();
            for (int j=0; j<20; j++) trains[i].add("0");
        }

        for (int c=0; c<m; c++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int i = Integer.parseInt(st.nextToken())-1;
            if (command.equals("1"))
                trains[i].set(Integer.parseInt(st.nextToken())-1,"1");
            else if (command.equals("2"))
                trains[i].set(Integer.parseInt(st.nextToken())-1,"0");
            else if (command.equals("3")) {
                trains[i].add(0,"0");
                trains[i].remove(trains[i].size()-1);
            } else {
                trains[i].add("0");
                trains[i].remove(0);
            }
        }

        Set<String> set = new HashSet<>();
        int answer = 0;
        for (ArrayList<String> train : trains) {
            StringBuilder sb = new StringBuilder();
            for (String info : train) sb.append(info);
            if (!set.contains(sb.toString())) {
                set.add(sb.toString());
                answer++;
            }
        }
        System.out.println(answer);
    }
}

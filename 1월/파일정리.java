import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

// BOJ 20291 SILVER 3
// 구현, 자료 구조
public class 파일정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        TreeMap<String,Integer> rbt = new TreeMap<>(String::compareTo);
        for (int i=0; i<n; i++) {
            String extension = br.readLine().split("\\.")[1];
            rbt.put(extension, rbt.getOrDefault(extension,0)+1);
        }

        while (!rbt.isEmpty()) {
            String key = rbt.firstKey();
            sb.append(key).append(" ").append(rbt.get(key)).append("\n");
            rbt.remove(key);
        }

        System.out.println(sb);
    }
}

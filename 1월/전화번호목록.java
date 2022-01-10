import java.util.HashMap;

// Programmers Level 2
// 해쉬
public class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();
        int len = phone_book.length;
        for(int i = 0; i < len; i++)
            map.put(phone_book[i], 0);

        for(int i = 0; i < len; i++) {
            for(int j = 1; j < phone_book[i].length(); j++) {
                if(map.containsKey(phone_book[i].substring(0,j))) return false;
            }
        }
        return true;
    }
}

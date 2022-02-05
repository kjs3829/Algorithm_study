import java.util.*;

// Programmers Level2
// 자료구조, 캐시
// 40분 소요
public class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        Set<String> cache = new LinkedHashSet<>();
        int executionTime = 0;
        final int CACHE_HIT_TIME = 1;
        final int CACHE_MISS_TIME = 5;

        if (cacheSize == 0) return cities.length*CACHE_MISS_TIME;

        for (String city : cities) {
            String cityName = city.toLowerCase();

            //cache hit
            if (cache.contains(cityName)) {
                cache.remove(cityName);
                executionTime += CACHE_HIT_TIME;
            }

            //cache miss
            else {

                //cache full
                if (cache.size() >= cacheSize)
                    cache.remove(String.valueOf(cache.toArray()[0]));

                executionTime += CACHE_MISS_TIME;
            }

            cache.add(cityName);
        }

        return executionTime;
    }
}

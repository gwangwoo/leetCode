import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(num -> {
            if(!map.containsKey(num)) {
                map.put(num, 1);
                return;
            }
            map.put(num, map.get(num)+1);
        });
        AtomicInteger answer = new AtomicInteger(-1987654321);
        map.forEach((k,v) -> {
            if(v == 1) {
                answer.set(k);
            }
        });
        return answer.get();
    }
}
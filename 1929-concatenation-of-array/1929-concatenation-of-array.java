import java.util.*;
class Solution {
    public int[] getConcatenation(int[] nums) {
        List<Integer> arl = new ArrayList<>();
        int cnt = 2;
        while(cnt-- > 0) {
            for(int i = 0 ; i < nums.length; i++) {
                arl.add(nums[i]);
            }
        }
        return arl.stream().mapToInt(Integer::intValue).toArray();
    }
}
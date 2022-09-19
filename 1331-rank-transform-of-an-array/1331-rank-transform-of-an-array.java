import java.util.*;
class Solution {
    public int[] arrayRankTransform(int[] arr) {
    Map<Integer, Integer> rankMap = new HashMap<>();
    int[] rankArr = new int[arr.length];
    System.arraycopy(arr, 0, rankArr, 0, arr.length);
    Arrays.sort(rankArr);
    for (int i = 1; i <= rankArr.length; i++) {
      if (!rankMap.containsKey(rankArr[i-1])) {
        rankMap.put(rankArr[i-1], rankMap.size()+1);
      }
    }
    int[] answer = new int[arr.length];
    for(int i = 0 ; i < arr.length ; i++) {
      answer[i] = rankMap.get(arr[i]);
    }
    return answer;
  }
}
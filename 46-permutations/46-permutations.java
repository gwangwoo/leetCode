import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
    int N = nums.length;

    boolean[] visited = new boolean[N];
    List<List<Integer>> answer = new ArrayList<>();

    go(nums, visited, 0, N, new ArrayList(), answer);
    return answer;
  }
    
    private void go(int[] nums, boolean[] visited, int idx, int N, List<Integer> arl, List<List<Integer>> answer) {
    if(idx == N) {
      answer.add(new ArrayList<>(arl));
      return;
    }

    for(int i = 0 ; i < N ; i++) {
      if(visited[i]) continue;
      visited[i] = true;
      int index = arl.size();
      arl.add(nums[i]);
      go(nums, visited, idx+1, N, arl, answer);
      arl.remove(index);
      visited[i] = false;
    }
  }
}
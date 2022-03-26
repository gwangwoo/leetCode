class Solution {
   public void rotate(int[] nums, int k) {
    Deque<Integer> q = new LinkedList<>();
    for (int i = 0; i < nums.length; i++) q.add(nums[i]);
    k %= nums.length;
    while(k-- > 0) q.addFirst(q.pollLast());
    int size = q.size();
    for(int i = 0 ; i < size ; i++) nums[i] = q.poll();
  }
}
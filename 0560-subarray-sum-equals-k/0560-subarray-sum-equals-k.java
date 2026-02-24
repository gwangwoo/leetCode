class Solution {
    public int subarraySum(int[] nums, int k) {
        int N = nums.length;
        int[] psum = new int[N+1];
        psum[1] = nums[0];
        for (int i = 2 ; i <= N ; i++) {
            psum[i] = psum[i-1] + nums[i-1];
        }
        int answer = 0;
        for (int i = 0 ; i < N ; i++) {
            for (int j = i+1 ; j <= N ; j++) {
                int diff = psum[j] - psum[i];
                if (diff == k) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
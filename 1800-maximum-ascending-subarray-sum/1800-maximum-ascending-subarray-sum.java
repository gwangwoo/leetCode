class Solution {
    public static int maxAscendingSum(int[] nums) {
        int N = nums.length;
        int[] psum = new int[N+1];

        psum[0] = nums[0];
        int answer = psum[0];
        for (int i = 1 ; i < N ; i++) {
            if (nums[i] > nums[i-1]) {
                psum[i] = psum[i-1] + nums[i];
            } else {
                psum[i] = nums[i];
            }
            answer = Math.max(answer, psum[i]);
        }
        return answer;

    }
}
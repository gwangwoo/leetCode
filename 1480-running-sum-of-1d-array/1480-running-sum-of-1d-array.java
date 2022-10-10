class Solution {
    public int[] runningSum(int[] nums) {
        int N = nums.length;
        int[] psum = new int[N];
        psum[0] = nums[0];
        for(int i = 1 ; i < N; i++) {
            psum[i] = psum[i-1] + nums[i];
        } 
        return psum;
    }
}
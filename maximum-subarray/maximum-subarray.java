class Solution {
    public int maxSubArray(int[] nums) {
        int N = nums.length;
        int result = nums[0];
        int localSum = nums[0]; 
        for(int i = 1 ; i < N ; i++) {
            localSum = Math.max(nums[i], nums[i] + localSum);
            result = Math.max(result, localSum);
        }
        return result;
    }
}
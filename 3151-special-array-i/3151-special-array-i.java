class Solution {
    public boolean isArraySpecial(int[] nums) {
        int N = nums.length;
        for (int i = 0 ; i < N-1 ; i++) {
            int j = i+1;
            if (nums[i] % 2 == nums[j] % 2) {
                return false;
            }
        }
        return true;
    }
}
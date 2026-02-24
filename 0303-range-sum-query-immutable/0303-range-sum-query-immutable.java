class NumArray {
    int nums[];
    int psum[];
    public NumArray(int[] nums) {
        int N = nums.length;
        psum = new int[N];
        psum[0] = nums[0];
        for (int i = 1 ; i < N ; i++) {
            psum[i] = psum[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if (left == 0) {
            return psum[right];
        }
        return psum[right] - psum[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = 
 */
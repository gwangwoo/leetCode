class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int before = -12345678;
        int N = nums.length;
        for(int j = 0 ; j < N ; j++) {
            if(nums[j] != before) {
                nums[i] = nums[j];
                before = nums[j];
                i++;
            }
        }
        return i;
        
    }
}
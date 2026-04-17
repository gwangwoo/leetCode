class Solution {
    public static int singleNumber(int[] nums) {
        int offset = 30001;
        int[] nCount = new int[offset*2];
        for (int i = 0 ; i < nums.length ; i++) {
            nCount[nums[i] + offset]++;
        }
        int answer = 0;
        for (int i = 0 ; i < nCount.length ; i++) {
            if (nCount[i] == 1) {
                return i - offset;
            }
        }
        return -1;
    }
}
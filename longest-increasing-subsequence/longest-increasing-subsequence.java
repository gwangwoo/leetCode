class Solution {
    static int binarySearch(int dp[], int s, int e, int val) {
		int ret = 0;
		int left = 0;
		int right = e;
		while(left <= right) {
			int mid = (left + right) >> 1;
			if(dp[mid] < val) {
				left = mid+1;
			}else {
				right = mid-1;
				ret = mid;
			}
		}
		return ret;
	}
	
	public static int lengthOfLIS(int[] nums) {
        int answer = 0;
        int N = nums.length;
        int dp[] = new int[N];
        dp[0] = nums[0];
        int idx = 0;
        for(int i = 1 ; i < N ; i++) {
        	if(dp[idx] < nums[i]) {
        		dp[++idx] = nums[i];
        	}else {
        		int val = binarySearch(dp,0,idx, nums[i]);
        		dp[val] = nums[i];
        	}
        }
        return idx+1;
    }
}
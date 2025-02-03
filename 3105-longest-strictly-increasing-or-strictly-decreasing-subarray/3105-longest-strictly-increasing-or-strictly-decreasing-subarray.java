class Solution {
    static int[] increasing;
    static int[] decreasing;
    public static int longestMonotonicSubarray(int[] nums) {
        int N = nums.length;
        increasing = new int[N];
        decreasing = new int[N];

        increasing[0] = decreasing[0] = 1;

        for (int i = 1 ; i < N ; i++) {
            if (nums[i-1] < nums[i]) {
                increasing[i] = increasing[i-1] + 1;
            } else {
                increasing[i] = 1;
            }

            if (nums[i-1] > nums[i]) {
                decreasing[i] = decreasing[i-1] + 1;
            } else {
                decreasing[i] = 1;
            }
        }

        int incMax = Arrays.stream(increasing).max().getAsInt();
        int decMax = Arrays.stream(decreasing).max().getAsInt();
        return Math.max(incMax, decMax);
    }

}
class Solution {
    public static boolean check(int[] nums) {
        boolean nonDecreasingOrder = isNonDecreasingOrder(nums);
        if (nonDecreasingOrder) {
            return true;
        }
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            rotate(nums);
            if (isNonDecreasingOrder(nums)) {
                return true;
            }
        }
        return false;
    }
    private static void rotate(int[] nums) {
        int N = nums.length;
        int nextValue = nums[0];
        for (int i = 0 ; i < nums.length ; i++) {
            int temp = nums[(i+1) % N];
            nums[(i+1) % N] = nextValue;
            nextValue = temp;
        }
    }

    private static boolean isNonDecreasingOrder(int[] nums) {
        int N = nums.length;
        boolean flag = true;
        for (int i = 0; i < N -1 ; i++) {
            if (nums[i] > nums[i+1]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
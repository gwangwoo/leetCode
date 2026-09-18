class Solution {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            for (int num2 : nums2) {
                int sum = num + num2;
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }

        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int sum = num3 + num4;
                if (map.containsKey(-sum)) answer += map.get(-sum);
            }
        }
        return answer;
    }
}
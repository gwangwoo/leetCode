class Solution {
    public static int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                map.merge(nums[i] * nums[j], 1, Integer::sum);
            }
        }
        AtomicInteger answer = new AtomicInteger();
        map.values()
           .stream()
           .filter(value -> value >= 2)
           .forEach(value -> {
               System.out.println(combination(value));
               answer.addAndGet((int) combination(value) * 8);
           });
        return answer.get();
    }

    private static long combination(int value) {
        return fact(value) / 2 / fact(value - 2);
    }

    private static long fact(int value) {
        long answer = 1;
        for (int i = 2; i <= value; i++) {
            answer *= i;
        }
        return answer;
    }
}
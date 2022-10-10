class Solution {
    public int[] shuffle(int[] nums, int n) {
        List<Integer> list = new ArrayList<>();
        int j = n;        
        for(int i = 0 ; i < n ; i++, j++) {
            list.add(nums[i]);
            list.add(nums[j]);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
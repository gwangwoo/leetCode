class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
    int answer[] = new int[queries.length];
    int evenSum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % 2 == 0) evenSum += nums[i];
    }

    for (int i = 0; i < queries.length; i++) {
      int value = queries[i][0];
      int idx = queries[i][1];
      if(nums[idx] % 2 == 0) {
        if((nums[idx] + value) % 2 == 0) evenSum += value;
        else evenSum -= nums[idx];
      }else {
        if((nums[idx] + value) % 2 == 0) evenSum += (nums[idx] + value);
      }
      nums[idx] += value;
      answer[i] = evenSum;
    }
    return answer;
  }

}
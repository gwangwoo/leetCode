class Solution {
     public static int[] twoSum(int[] numbers, int target) {
    int answer[] = new int[2];
    for(int i = 0 ; i < numbers.length; i++) {
      int select = binarySearch(numbers, i, target);
      if(select == -1) continue;
      answer[0] = i+1;
      answer[1] = select+1;
      break;
    }
    return answer;
  }

  private static int binarySearch(int[] nums, int i, int target) {
    int left = i+1;
    int right = nums.length-1;
    int answer = -1;
    while(left <= right) {
      int mid = (left + right) >> 1;
      if(nums[mid]+nums[i] == target) return mid;
      else if(nums[mid]+nums[i] < target) {
        left = mid+1;
      }else {
        right = mid-1;
      }
    }
    return answer;
  }
}
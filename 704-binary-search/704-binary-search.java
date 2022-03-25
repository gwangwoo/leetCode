class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target);
    }
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int answer = -1;
        while(left <= right) {
          int mid = (left + right) >> 1;
          if(nums[mid] < target) {
            left = mid+1;
          }else if(nums[mid] == target){
            answer = mid;
            break;
          }else  {
            right = mid-1;
          }
        }
        return answer;
    }
}
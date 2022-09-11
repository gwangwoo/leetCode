import java.util.*;

class Solution {

    public static int[] twoSum(int[] nums, int target) {
    int N = nums.length;
    Pair arr[] = new Pair[N];
    for(int i = 0 ; i < N ; i++) {
      arr[i] = new Pair(i, nums[i]);
    }
    Arrays.sort(arr);
    for(int i = 0 ; i < N ; i++) {
      int find = target - arr[i].val;
      int idx = binarySearch(i, arr, find);
      if(idx == -1) continue;
      if(arr[idx].val + arr[i].val == target) {
        return Arrays.stream(new int[]{arr[i].idx,arr[idx].idx}).sorted().toArray();
      }
    }
    return null;
  }

  private static int binarySearch(int i, Pair[] arr, int find) {
    int left = i+1;
    int right = arr.length-1;
    while(left <= right) {
      int mid = (left + right) >> 1;
      if(arr[mid].val == find) {
        return mid;
      }else if(arr[mid].val < find) {
        left = mid+1;
      }else right = mid-1;
    }
    return -1;
  }


  static class Pair implements Comparable<Pair>{
    int idx,val;
    Pair(int idx, int val) {
      this.idx = idx;
      this.val = val;
    }

    @Override
    public int compareTo(Pair target) {
      return this.val - target.val;
    }
  }
    

}
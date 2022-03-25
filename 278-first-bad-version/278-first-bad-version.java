/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
    long left = 1;
    long right = n;
    long answer = -1;
    while(left <= right) {
      long mid = (left + right) >> 1;
      if(!isBadVersion((int)mid)) {
        left = mid+1;
      }else {
        right = mid-1;
        answer = mid;
      }
    }
    return (int)answer;
  }
}
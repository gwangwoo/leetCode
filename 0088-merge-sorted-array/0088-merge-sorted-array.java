class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int[] answer = new int[m+n];
        int idx = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                answer[idx++] = nums1[i++]; 
            } else {
                answer[idx++] = nums2[j++];
            }
        }
        while (i < m) {
           answer[idx++] = nums1[i++];  
        }
        while (j < n) {
            answer[idx++] = nums2[j++];
        }
        for (int k = 0 ; k < n+m ; k++) {
            nums1[k] = answer[k];
        }
    }    
}
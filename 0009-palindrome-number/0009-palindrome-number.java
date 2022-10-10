class Solution {
    public boolean isPalindrome(int x) {
        String number = x+"";
        int N = number.length();
        for(int i = 0 ; i < N/2 ; i++) {
            if(number.charAt(i) != number.charAt(N-i-1)) return false;
        }
        return true;
    }
}
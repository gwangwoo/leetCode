class Solution {
    public static void reverseString(char[] s) {
    char[] answer = new char[s.length];
    for(int i = 0 ; i < s.length ; i++) answer[s.length-i-1] = s[i];
    for(int i = 0 ; i < s.length ; i++) s[i] = answer[i];
  }
}
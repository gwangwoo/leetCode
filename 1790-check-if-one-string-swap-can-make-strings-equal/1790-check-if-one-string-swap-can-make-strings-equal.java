class Solution {
    public static boolean areAlmostEqual(String s1, String s2) {
        int diff = 0;
        int N = s1.length();
        char[] s1Chars = new char[26];
        char[] s2Chars = new char[26];

        for (int i = 0 ; i < N ; i++) {
            s1Chars[s1.charAt(i) - 'a']++;
            s2Chars[s2.charAt(i) - 'a']++;
        }

        for (int i = 0 ; i < 26 ; i++) {
            if (s1Chars[i] != s2Chars[i]) {
                return false;
            }
        }
        for (int i = 0 ; i < N ; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff == 0 || diff == 2;
    }
}
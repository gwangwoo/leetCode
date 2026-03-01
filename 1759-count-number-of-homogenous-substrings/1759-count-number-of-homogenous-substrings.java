class Solution {
    static final int MOD = 1_000_000_007;
    public int countHomogenous(String s) {
        List<Character> chars = new ArrayList<>();
        List<Integer> lens = new ArrayList<>();
        int N = s.length();
        int i = 0;
        while (i < N) {
            char ch = s.charAt(i);
            int j = i;
            while (j < N && s.charAt(j) == ch) j++;
            chars.add(ch);
            lens.add(j-i);
            i = j;
        }
        long answer = 0L;
        for (int l : lens) {
            long add = (long) l * (l + 1) / 2;
            answer = (answer + add) % MOD;
        }
        return (int)answer;

    }
}
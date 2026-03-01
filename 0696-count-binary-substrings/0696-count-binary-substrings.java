class Solution {
    public int countBinarySubstrings(String s) {
        List<Character> chars = new ArrayList<>();
        List<Integer> lens = new ArrayList<>();
        int N = s.length();

        int i = 0;
        while (i < N) {
            char ch = s.charAt(i);
            int j = i;
            while (j < N && ch == s.charAt(j)) j++;
            chars.add(ch);
            lens.add(j - i);
            i = j;
        }
        int answer = 0;
        for (i = 1 ; i < lens.size() ; i++) {
            answer += Math.min(lens.get(i-1) , lens.get(i));
        }
        return answer;
    }
}
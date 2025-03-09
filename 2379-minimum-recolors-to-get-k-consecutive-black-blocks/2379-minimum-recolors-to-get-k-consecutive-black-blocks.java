class Solution {
    public int minimumRecolors(String blocks, int k) {
        int N = blocks.length();
        int answer = N;
        int blackCount = 0;
        for (int i = 0 ; i < k ; i++) {
            blackCount += blocks.charAt(i) == 'B' ? 1 : 0;
        }
        answer = Math.min(answer, k - blackCount);
        int start = 0;
        for (int i = k ; i < N ; i++) {
            if (blocks.charAt(i) == 'B') {
                blackCount++;
            }
            if (blocks.charAt(start++) == 'B') {
                blackCount--;
            }
            answer = Math.min(answer, k - blackCount);
        }
        return answer;
    }
}
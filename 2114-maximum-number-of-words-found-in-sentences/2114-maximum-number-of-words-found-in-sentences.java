import java.util.*;
class Solution {
    public int mostWordsFound(String[] sentences) {
        int answer = 0;
        for(int i = 0 ; i < sentences.length ; i++) {
            StringTokenizer st = new StringTokenizer(sentences[i]);
            answer = Math.max(answer, st.countTokens());
        }
        return answer;
    }
}
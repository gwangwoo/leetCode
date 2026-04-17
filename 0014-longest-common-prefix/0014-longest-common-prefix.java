class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if (Arrays.stream(strs).filter(str -> str.length() == 0).count() > 0) {
            return "";
        }
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        int N = strs[idx].length();
        while (N-- > 0) {
            char now = ' ';
            boolean exitFlag = false;
            for (int i = 0 ; i < strs.length ; i++) {
                String str = strs[i];
                if (idx < str.length()) {
                    if (now == ' ') {
                        now = str.charAt(idx);
                    } else if (now != str.charAt(idx)) {
                        exitFlag = true;
                        break;
                    }
                } else {
                    return answer.toString();
                }
            }
            if (exitFlag) {
                return answer.toString();
            }
            idx++;
            answer.append(now);
        }
        return answer.toString();
    }
}
import java.util.*;

class Solution {
      public static List<String> printVertically(String s) {
    StringTokenizer st = new StringTokenizer(s);
    int max = 0;
    List<String> arl = new ArrayList<>();
    int n = st.countTokens();
    for (int i = 0; i < n; i++) {
      String str = st.nextToken();
      max = Math.max(max, str.length());
      arl.add(str);
    }
    int N = arl.size();
    List<String> answer = new ArrayList<>();
    for (int i = 0; i < max; i++) answer.add("");

    for (int i = 0; i < max; i++) {
      for (int j = 0; j < N; j++) {
        if (arl.get(j).length() > i) {
          char ch = arl.get(j).charAt(i);
          answer.set(i, answer.get(i) + ch);
        } else {
          answer.set(i, answer.get(i) + " ");
        }
      }
    }
    for(int i = 0 ; i < max ; i++) {
      answer.set(i, answer.get(i).stripTrailing());
    }
    return answer;
  }
}
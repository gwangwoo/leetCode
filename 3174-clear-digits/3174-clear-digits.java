import java.util.Stack;

class Solution {
    public static String clearDigits(String s) {
        Stack<Character> stk = new Stack<>();
        int N = s.length();
        
        for (int i = 0 ; i < N ; i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                stk.push(ch);
                continue;
            }
            stk.pop();
        }
        StringBuilder answer = new StringBuilder();
        while (!stk.isEmpty()) {
            answer.append(stk.pop());
        }
        return answer.reverse().toString();
    }
}
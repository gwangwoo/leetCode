import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        int N = s.length();
        for(int i = 0 ; i < N ; i++) {
            char now = s.charAt(i);
            if(now == '(' || now == '[' || now == '{') stk.add(now);
            else if(now == ')') {
                if(stk.isEmpty() || stk.peek() != '(')  return false;
                stk.pop();
            }else if(now == ']') {
                if(stk.isEmpty() || stk.peek() != '[') return false;
                stk.pop();
            }else if(now == '}') {
                if(stk.isEmpty() || stk.peek() != '{') return false;
                stk.pop();
            }
        }
        if(!stk.isEmpty()) return false;
        return true;
    }
}
import java.util.Stack;
class Solution {
    public static String minRemoveToMakeValid(String str) {
        String first = processString(str, '(', ')', true);
        return processString(first, ')', '(', false);
    }

    private static String processString(String str, char firstParentheses, char lastParentheses, boolean forward) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        int N = str.length();
        int start = forward ? 0 : N - 1;
        int end = forward ? N : -1;
        int increment = forward ? 1 : -1;

        for(int i = start ; i != end ; i += increment) {
            if (str.charAt(i) != firstParentheses && str.charAt(i) != lastParentheses) {
                answer.append(str.charAt(i));
                continue;
            }
            if (str.charAt(i) == firstParentheses) {
                stk.add(str.charAt(i));
                answer.append(firstParentheses);
            } else if (str.charAt(i) == lastParentheses) {
                if (!stk.isEmpty() && stk.peek() == firstParentheses) {
                    stk.pop();
                    answer.append(lastParentheses);
                }
            }
        }
        if (!forward) {
            answer.reverse(); // 역순으로 처리한 경우 문자열을 뒤집어야 함
        }
        return answer.toString();
    }
}
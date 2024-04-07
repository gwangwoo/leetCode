import java.util.Stack;
class Solution {
    public static boolean checkValidString(String str) {
        int leftMax = 0, leftMin = 0;
        for(int i = 0 ; i < str.length() ; i++) {
            if (str.charAt(i) == '(') {
                leftMax++; leftMin++;
            } else if(str.charAt(i) == ')') {
                leftMax--; leftMin--;
            } else {        // wildcard
                leftMax++; leftMin--;
            }
            if (leftMax < 0) {
                return false;
            }
            if (leftMin < 0) leftMin = 0;

        }
        return leftMin == 0;
    }
}
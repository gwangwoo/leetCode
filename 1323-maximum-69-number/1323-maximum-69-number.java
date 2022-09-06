import java.util.*;

class Solution {
    public int maximum69Number (int num) {
        String str = num+"";
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i = 0 ; i < str.length() ; i++) {
            if(!flag && str.charAt(i) == '6') {
                sb.append("9");
                flag = true;
            }
            else sb.append(str.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }
}
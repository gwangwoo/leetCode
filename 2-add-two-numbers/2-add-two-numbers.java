/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.math.*;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String left = dfs(l1, "");
        String right = dfs(l2, "");
        BigInteger leftValue = new BigInteger(left);
        BigInteger rightValue = new BigInteger(right);
        String result = leftValue.add(rightValue).toString();
        ListNode answer = new ListNode();
        int count = result.length()-1;
        return generateNode(answer, result, count);
    }
    
    public String dfs(ListNode ln, String str) {
        if(ln.next == null) return ln.val+"";
        str += dfs(ln.next, str);
        return str += ln.val+"";
    }
    
    public ListNode generateNode(ListNode ln, String result, int count) {
        if(count == 0) return new ListNode(result.charAt(count)-'0');
        ListNode newLn = new ListNode(result.charAt(count)-'0');
        newLn.next = generateNode(ln, result, count-1);
        return newLn;
    }
}
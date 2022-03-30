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
class Solution {
    public ListNode middleNode(ListNode head) {
        int size = 1;
        ListNode checkSize = head;
        while(checkSize.next != null) {
            size++;
            checkSize = checkSize.next;
        }
        int start = size / 2 + 1;
        while(--start > 0) {
            head = head.next;
        }
        return head;
    }
}
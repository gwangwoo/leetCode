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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sizeCheck = head;
        int size = 1;
        while(sizeCheck.next != null) {
            size++;
            sizeCheck = sizeCheck.next;
        }
        int find = size - n;
        ListNode deleteNode = head;
        while(--find > 0) {
            deleteNode = deleteNode.next;
        }
        if(size == 1 || size - n == 0) head = head.next;
        else deleteNode.next = deleteNode.next.next;
        return head;
    }
}
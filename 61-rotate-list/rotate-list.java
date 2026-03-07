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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        // Step 1: Find length
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        
        // Optimize k
        k = k % length;
        if (k == 0) return head;
        
        // Step 2: Use two pointers to find the split point
        ListNode fast = head;
        ListNode slow = head;
        
        // Move fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        
        // Move both pointers until fast reaches the end
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // Now slow is at the new tail, fast at the old tail
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        
        return newHead;
    }
}
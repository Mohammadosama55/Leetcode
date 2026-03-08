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
    public boolean isPalindrome(ListNode head) {
         List<Integer> list = new ArrayList<>();
        while (head != null) { list.add(head.val); head = head.next; }
        return IntStream.range(0, list.size() / 2)
                       .allMatch(i -> list.get(i).equals(list.get(list.size() - 1 - i)));
    
        
    }
}
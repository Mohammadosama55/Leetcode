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
        if(head ==null ||head.next==null || k==0){
            return head;
        }
        int lenght=1;
        ListNode tail=head;
        while(tail.next!=null){
            lenght++;
            tail=tail.next;
        }
        k=k%lenght;
        if(k==0)return head;
        tail.next=head;
        
        int stop=lenght-k;
        ListNode front=head;
        for(int i=1;i<stop;i++){
            front=front.next;
        }
        ListNode newHead=front.next;
        front.next=null;
        return newHead;
    }
}
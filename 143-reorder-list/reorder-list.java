import java.util.Stack;

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        // Step 1: Push all nodes onto stack
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        int length = 0;
        
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
            length++;
        }
        
        // Step 2: Reorder by interleaving from front and back
        curr = head;
        ListNode nextNode = null;
        
        for (int i = 0; i < length / 2; i++) {
            nextNode = curr.next;
            ListNode lastNode = stack.pop();
            
            curr.next = lastNode;
            lastNode.next = nextNode;
            
            curr = nextNode;
        }
        
        // Step 3: Set the last node's next to null to avoid cycles
        curr.next = null;
    }
}
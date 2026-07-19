/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
         List<Integer>ans=new LinkedList<>();
        if(root==null){
            return ans;
        }
       
        Queue<TreeNode>queen=new LinkedList<>();
        queen.offer(root);
        while(!queen.isEmpty()){
            int size=queen.size();
            for(int i=0;i<size;i++){
                TreeNode node=queen.poll();
                if(i==size-1){
                    ans.add(node.val);
                }
                if(node.left !=null){
                    queen.offer(node.left);
                }if(node.right !=null){
                    queen.offer(node.right);
                }
            }}
        
        return ans;
        
    }
}
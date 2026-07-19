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
    private int k;
    private int ans;
        
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        inoder(root);
        return ans;  
    }
    private void inoder(TreeNode root){
        if(root==null){
            return;
        }
        inoder(root.left);
        k--;
        if(k==0){
            ans=root.val;
            return;
        }
        inoder(root.right);
    }
}
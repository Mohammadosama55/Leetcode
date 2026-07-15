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
    public boolean isBalanced(TreeNode root) {
        return helper(root) !=-1;
        
    }
    private int helper(TreeNode root){
        if(root ==null){
            return 0;
        }
        int leftNode=helper(root.left);
        int rightNode=helper(root.right);
        if(leftNode ==-1 || rightNode==-1){
            return -1;
        }
        if(Math.abs(leftNode-rightNode)>1){
            return -1;
        }
        return Math.max(leftNode,rightNode)+1;
    } 
}
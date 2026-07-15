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
        int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
         Height(root);
            return diameter;
        }
        private int Height(TreeNode root){
            if(root==null){
                return 0;
            }
            int l=Height(root.left);
            int r=Height(root.right);
            diameter=Math.max(diameter,l+r);
            return Math.max(r,l)+1;
        }
    }

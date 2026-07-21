// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         if(preorder.length ==0 && inorder.length==0){
//             return ;
//         }
//         int preroot=preorder[0];
//         TreeNode root=new TreeNode(preroot);
//         int rootInInorder=0;
//         for(int i=0;i<inorder.length-1;i++){
//             if(preroot==inorder[i]){
//                 rootInInorder=i;
//                 break;
//             }
//         }
//         int[] leftInorder = new int[rootInInorder];
//         int[] rightInorder = new int[inorder.length - rootInInorder - 1];
        
//         for (int i = 0; i < inorder.length; i++) {
//             if (i < rootInInorder) {
//                 leftInorder[i] = inorder[i];
//             } else if (i > rootInInorder) {
//                 rightInorder[i - rootInInorder - 1] = inorder[i];
//             }
//         }
//         int leftSize = leftInorder.length;
//         int[] leftPreorder = new int[leftSize];
//         int[] rightPreorder = new int[preorder.length - 1 - leftSize];
        
       
//         for (int i = 0; i < leftSize; i++) {
//             leftPreorder[i] = preorder[1 + i];
//         }
        
        
//         for (int i = 0; i < rightPreorder.length; i++) {
//             rightPreorder[i] = preorder[1 + leftSize + i];
//         }
        
        
//         root.left = buildTree(leftPreorder, leftInorder);
//         root.right = buildTree(rightPreorder, rightInorder);
        
//         return root;
//     }
// }


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        
       
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        
       
        int rootInInorder = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootInInorder = i;
                break;
            }
        }
        
       
        int[] leftInorder = new int[rootInInorder];
        int[] rightInorder = new int[inorder.length - rootInInorder - 1];
        
        for (int i = 0; i < inorder.length; i++) {
            if (i < rootInInorder) {
                leftInorder[i] = inorder[i];
            } else if (i > rootInInorder) {
                rightInorder[i - rootInInorder - 1] = inorder[i];
            }
        }
        
        
        int leftSize = leftInorder.length;
        int[] leftPreorder = new int[leftSize];
        int[] rightPreorder = new int[preorder.length - 1 - leftSize];
        
        
        for (int i = 0; i < leftSize; i++) {
            leftPreorder[i] = preorder[1 + i];
        }
        
        
        for (int i = 0; i < rightPreorder.length; i++) {
            rightPreorder[i] = preorder[1 + leftSize + i];
        }
        
        
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);
        
        return root;
    }
}
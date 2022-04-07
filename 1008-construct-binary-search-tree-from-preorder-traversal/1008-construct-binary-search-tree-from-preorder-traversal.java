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
    public TreeNode bstFromPreorder(int[] preorder) {
        int [] index = new int[1];
        index[0] = 0;
        
        return buildTree(preorder,index,Integer.MAX_VALUE);
    }
        private TreeNode buildTree(int [] preOrder,int[] index,int bound){
            if(preOrder.length == index[0] || preOrder[index[0]] > bound)
                return null;
            
            TreeNode root = new TreeNode(preOrder[index[0]++]);
            
            root.left = buildTree(preOrder,index,root.val);
            root.right = buildTree(preOrder,index,bound);
            
            return root;
        }
    }

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
    public int maxPathSum(TreeNode root) {
        
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        max(root,max);
        
        return max[0];
     
    }
    
    private int max(TreeNode node,int [] maxPath){
           if(node == null){
            return 0;
        }
        
        int leftSum = Math.max(0,max(node.left,maxPath));
        int rightSum = Math.max(0,max(node.right,maxPath));
        
        maxPath[0] = Math.max(maxPath[0],leftSum+rightSum+node.val);
        return node.val + Math.max( leftSum , rightSum);
    }
}
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
    int answer = 0;
    public int longestUnivaluePath(TreeNode root) {        
        findArrowLength(root);
        return answer;
    }
    
    private int findArrowLength(TreeNode root){
        if(root == null) return 0;
        
        int left = findArrowLength(root.left);
        int right = findArrowLength(root.right);
        int arraowLeft =0,arraowRight = 0;
        if(root.left != null && root.left.val == root.val){
            arraowLeft = left + 1;
        }
        
        if(root.right != null && root.right.val == root.val){
            arraowRight = right + 1;
        }
        
        answer = Math.max(answer, arraowLeft+arraowRight);
        
        return Math.max(arraowLeft,arraowRight);
    }
}
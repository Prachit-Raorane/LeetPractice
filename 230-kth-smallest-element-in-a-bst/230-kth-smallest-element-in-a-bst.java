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
    
    int val;
    int index;
    public int kthSmallest(TreeNode root, int k) {
       kThHelper(root,k);
    return val;
    }
    
    private void kThHelper(TreeNode node,int k ){
        
        if(node == null) return;
        kThHelper(node.left,k);
        
        index ++;
        if(k == index){
            val = node.val;
            return;
        }
        
        kThHelper(node.right,k);
        
    }
}
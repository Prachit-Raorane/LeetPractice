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
    TreeNode first;
    TreeNode last;
    TreeNode middle;
    TreeNode previous;
    
    public void recoverTree(TreeNode root) {
        first=last=middle=null;
        
        previous = new TreeNode(Integer.MIN_VALUE);
        
        inOrder(root);
        if(first!=null && last !=null){
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }else if(first!=null && middle !=null){
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }
    
    
    private void inOrder(TreeNode root){
        if(root == null ) return;
        inOrder(root.left);
        if(previous !=null &&  root.val < previous.val ){
            
            if(first == null){
                first = previous;
                middle = root;
            }else{
                last = root;
            }
        }
        
        previous = root;
        
        inOrder(root.right);
    }
}
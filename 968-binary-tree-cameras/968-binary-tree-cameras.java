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
    
    int cameras = 0;
    
    public enum Camera{HAS_CAMERA,COVERED,PLEASE_COVER};
    
    public int minCameraCover(TreeNode root) {
        return cover(root) == Camera.PLEASE_COVER ? ++cameras  : cameras;    
    }
    
    
    private Camera cover(TreeNode root){
        
        if (root == null ) return Camera.COVERED;
        
        Camera left = cover(root.left);
        Camera right = cover(root.right);
        
        if(left == Camera.PLEASE_COVER || right == Camera.PLEASE_COVER ){
            cameras ++;
            return Camera.HAS_CAMERA;
        }
        
        if(left == Camera.HAS_CAMERA || right == Camera.HAS_CAMERA){
            return Camera.COVERED;
        }
        
        return  Camera.PLEASE_COVER;
    }
}
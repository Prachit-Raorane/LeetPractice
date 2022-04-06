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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
       Map<Integer,Integer> locations = new HashMap<>();
        
        for (int i =0;i<inorder.length;i++){
            locations.put(inorder[i],i);
        }
        
        TreeNode root = buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length -1,locations );
        
        return root;
        
    }
    
    private TreeNode buildTree(int[] inOrder, int inStart,int inEnd,int[] postorder , int pStart, int pEnd,Map<Integer,Integer> locations){
        
        if(inStart > inEnd || pStart > pEnd) return null;
        
        TreeNode root = new TreeNode(postorder[pEnd]);
        
        int inRoot = locations.get(root.val);
        
        int numsOnLeft = inRoot - inStart;
        
        root.left = buildTree(inOrder,inStart,inRoot - 1,postorder,pStart,pStart+ numsOnLeft-1,locations);
        
        root.right = buildTree(inOrder,inRoot+1,inEnd,postorder,pStart+numsOnLeft,pEnd-1,locations);
        
        return root;
    }
}
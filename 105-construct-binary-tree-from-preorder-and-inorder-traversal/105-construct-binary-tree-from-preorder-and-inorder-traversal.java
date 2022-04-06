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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> locations = new HashMap<>();
        
        for (int i =0;i<inorder.length;i++){
            locations.put(inorder[i],i);
        }
        
        TreeNode root = buildTree(inorder,0,inorder.length-1,preorder,0,preorder.length -1,locations );
        
        return root;
        
    }
    
    private TreeNode buildTree(int[] inOrder, int inStart,int inEnd,int[] preOrder , int pStart, int pEnd,Map<Integer,Integer> locations){
        
        if(inStart > inEnd || pStart > pEnd) return null;
        
        TreeNode root = new TreeNode(preOrder[pStart]);
        
        int inRoot = locations.get(root.val);
        
        int numsOnLeft = inRoot - inStart;
        
        root.left = buildTree(inOrder,inStart,inRoot - 1,preOrder,pStart+1,pStart+ numsOnLeft,locations);
        
        root.right = buildTree(inOrder,inRoot+1,inEnd,preOrder,pStart+numsOnLeft + 1,pEnd,locations);
        
        return root;
    }
}
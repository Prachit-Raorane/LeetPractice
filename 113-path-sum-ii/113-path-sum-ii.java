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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        
         findPaths(root,targetSum,paths,new ArrayList<>());
        
        return paths;
    }
    
    private void findPaths(TreeNode root,int targetSum , List<List<Integer>> paths,List<Integer> path){
        
        if(root == null) return;
        
        path.add(root.val);
        
        if(root.left == null && root.right == null && targetSum  == root.val){
            paths.add(path);
            return;
        }
        
        findPaths(root.left,targetSum - root.val,paths,new ArrayList(path));
        
        findPaths(root.right,targetSum - root.val,paths,new ArrayList(path));
    }
}
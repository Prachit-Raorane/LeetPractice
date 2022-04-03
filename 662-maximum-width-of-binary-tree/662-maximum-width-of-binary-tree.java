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
    
    class Pair{
        TreeNode node;
        int index;
        
        Pair(TreeNode node,int index){
            this.node = node;
            this.index= index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root == null) return 0;
        
        int ans = 0;
        
        Queue<Pair> nodes = new LinkedList<>();
        
        nodes.offer(new Pair(root,0));
        
        while(!nodes.isEmpty()){
            
            int size = nodes.size();
            int min = nodes.peek().index;
            int first=0,last = 0;
            
            for(int i=0;i<size;i++){
                
                int currentIndex = nodes.peek().index - min;
                TreeNode node = nodes.poll().node;
                
                if(i==0){
                    first = currentIndex;
                }else if (i == size -1 ){
                    last = currentIndex;
                } 
                
                if(node.left !=null) nodes.offer(new Pair(node.left, currentIndex * 2 + 1));
                if(node.right !=null) nodes.offer(new Pair(node.right, currentIndex * 2 + 2));
            }
            
            ans = Math.max(ans,last- first+1);
        }
        
        return ans;
        
    }
}
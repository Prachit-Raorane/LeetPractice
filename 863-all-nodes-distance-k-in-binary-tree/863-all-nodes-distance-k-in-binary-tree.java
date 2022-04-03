/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private void markParents(TreeNode root,Map<TreeNode,TreeNode> parents){
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            
            if(current.left != null){
                parents.put(current.left,current);
                queue.offer(current.left);
            }
            
            
            if(current.right != null){
                parents.put(current.right,current);
                queue.offer(current.right);
            }
        }
    }
    
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    
        Map<TreeNode,TreeNode> parents = new HashMap<>();
        markParents(root,parents);
        Map<TreeNode,Boolean> visited = new HashMap<>();
        
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(target);
        visited.put(target,true);
        
        int currentLevel = 0;
        while(!nodes.isEmpty()){
        
            int size = nodes.size();
          
            if(currentLevel == k){
                break;
            }
           
            currentLevel++;
            
            for(int i=0; i< size;i++){
                  TreeNode node = nodes.poll();
                if(node.left!=null && !visited.containsKey(node.left)){
                    visited.put(node.left,true);
                    nodes.offer(node.left);
                }
                
                
                if(node.right!=null && !visited.containsKey(node.right)){
                    visited.put(node.right,true);
                    nodes.offer(node.right);
                }
                
                if(parents.containsKey(node) && !visited.containsKey(parents.get(node))){
                    visited.put(parents.get(node),true);
                    nodes.offer(parents.get(node));  
                }
            }
            
            
        }
        
        List<Integer> answer = new ArrayList<>();
        
        while(!nodes.isEmpty()){
            answer.add(nodes.poll().val);
        }
        
        return answer;
    }
}
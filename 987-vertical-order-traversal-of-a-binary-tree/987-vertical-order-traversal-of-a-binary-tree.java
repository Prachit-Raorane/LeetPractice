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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null) return Collections.emptyList();
       
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        
        Queue<Tuple> q = new LinkedList<>();
        
        q.offer(new Tuple(root,0,0));
        
        while(!q.isEmpty()){
            
            Tuple t = q.poll();
            
            TreeNode node = t.node;
            int x= t.x;
            int y = t.y;
            
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            
            if(! map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }
            
            map.get(x).get(y).offer(node.val);
            
            if(null != node.left){
                 q.offer(new Tuple(node.left,x-1,y+1));
            }
            
            if(null != node.right){
                 q.offer(new Tuple(node.right,x+1,y+1));
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(TreeMap<Integer,PriorityQueue<Integer>> ys: map.values()){
            List<Integer> temp = new ArrayList<>();
            
            for(PriorityQueue<Integer> vals : ys.values()){
                
                while(!vals.isEmpty()){
                        temp.add(vals.poll());
                    }
                
            }
            
            ans.add(temp);
            
        }
        
        return ans;
    }
    
   
}

class Tuple{
    TreeNode node;
    int x;
    int y;
    
    public Tuple(TreeNode node,int x , int y){
        this.node= node;
        this.x = x;
        this.y = y;
    }
}
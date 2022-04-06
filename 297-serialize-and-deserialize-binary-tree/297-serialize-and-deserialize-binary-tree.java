/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if ( root == null ) return "";
        
        String answer = "";
        Queue<TreeNode> nodes = new LinkedList<>();
        
        nodes.offer(root);
        
        while(!nodes.isEmpty()){
            TreeNode current = nodes.poll();
            if(current == null){
                answer+="#,";
            }else{
                answer+= current.val + ",";   
                nodes.offer(current.left);
                nodes.offer(current.right);
            }
            
            
        }
        
        return answer;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data == null || data.isEmpty()) return null;
        Queue<TreeNode> nodes = new LinkedList<>();
        String[] split = data.split(",");
        
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        nodes.offer(root);
        for(int i=1;i< split.length;i++){
            
            TreeNode current = nodes.poll();
            
            if(!split[i].equals("#")){
                
            
            TreeNode left =  new TreeNode(Integer.parseInt(split[i]));
            
            current.left = left;
            nodes.offer(left);
            }
            
            
            if(!split[++i].equals("#")){
                
            
            TreeNode right =  new TreeNode(Integer.parseInt(split[i]));
            
            current.right = right;
            nodes.offer(right);
            }
        }
        
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
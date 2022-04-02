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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return Collections.emptyList();
        
        final Queue<TreeNode> nodes = new LinkedList<>();
        int level = 1;
        List<List<Integer>>  answer = new ArrayList<>();
        
        nodes.offer(root);
        
        while(!nodes.isEmpty()){
            int size = nodes.size();
            List<Integer> temp = new ArrayList<>();
            
            for(int i=0;i<size;i++){
                
                TreeNode node = nodes.poll();
                temp.add(node.val);
                
                if(node.left != null) nodes.offer(node.left);
                if(node.right != null) nodes.offer(node.right);
            
            }
            //System.out.println("before "+temp );
            if(level%2 == 0) reverse(temp);
            //System.out.println("After "+temp );
            level ++;
            answer.add(temp);
        }
        
        
        return answer;
    }
    
    
    public void reverse(List<Integer> list) {
		int s = 0;
		int e = list.size() - 1;

		while(s < e) {
			int t = list.get(s);
			list.set(s, list.get(e));
			list.set(e, t);
            s++;
            e--;
		}
	}
}
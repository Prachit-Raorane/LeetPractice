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
class BSTIterator {

    private Stack<TreeNode> nodes = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    private void pushAll(TreeNode node){
        
        while(node != null){
            nodes.push(node);
            node = node.left;
        }
    }
    public int next() {
        TreeNode node = nodes.pop();
        pushAll(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !nodes.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
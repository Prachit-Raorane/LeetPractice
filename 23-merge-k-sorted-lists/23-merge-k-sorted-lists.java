/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.nullsFirst(Comparator.comparing(listNode -> listNode.val)));

        
        Arrays.stream(lists).filter(Objects::nonNull).forEach(
            node -> queue.add(node));
        
        ListNode head= null;
        ListNode result = null;
        
        while(!queue.isEmpty()){
            ListNode temp = queue.poll();
            
            if(head == null ){
                head = temp;
                result = temp;
            }else{
                head.next = temp;
                head = head.next;
            }
            if(temp.next !=null){
                queue.add(temp.next);
            }
        }
        
        return result;
    }
}
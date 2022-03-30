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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head==null || head.next == null || k == 0){
            return head;
        }
        //find length
        
        int length = 1;
        ListNode current = head;
        
        while(current.next != null){
            current = current.next;
            length++;
        }
        
        
        
        if(k==length){
            return head;
        }
        
        if(k>length){
            k = k% length;
        }
        
        if(k==0){
            return head;
        }
        
        current.next = head;
        
        int stepsToTake = length - k;
        
        
        //current = head;
        
        while(stepsToTake > 0 ){
            current = current.next;
            stepsToTake-- ;
        }
        
        ListNode newHead = current.next;
        
        current.next = null;
        
        return newHead;
        
        
        
    }
}
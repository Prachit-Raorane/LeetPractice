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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {



        ListNode result =  null;
        ListNode head = null;
        
        int carry = 0;
        while(true){
            int first =  l1 == null ? 0 : l1.val;
            int second = l2 == null ? 0 : l2.val;

            int sum = first + second + carry;

            if(sum >= 10){
                carry = 1;
                sum = sum - 10;
            }else{
                carry = 0;
            }

            ListNode temp = new ListNode(sum);
            if(head==null){
                result = temp;
                head = temp;
            }else{
                head.next = temp;
                head = head.next;
            }

            l1 =  l1 == null ? null : l1.next;
            l2 =  l2 == null ? null : l2.next ;
            if(l1 == null && l2== null && carry==0){
                break;
            }
        }

        return result;
    }
}
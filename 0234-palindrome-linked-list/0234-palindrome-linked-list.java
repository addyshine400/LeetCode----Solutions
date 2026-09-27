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
    public boolean isPalindrome(ListNode head) {

        if(head== null || head.next==null){
            return true;
        }
        // finding middle

        ListNode slow=head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        // reverse second half
        ListNode prev = null;
        ListNode curr = slow;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        //  compare first half to second half
        ListNode first=head;
        ListNode second = prev;
        while(second!=null){
            if(first.val !=second.val){
                return false;
            }
            first = first.next;
            second = second.next;
        }

        return true;
        
    }
}
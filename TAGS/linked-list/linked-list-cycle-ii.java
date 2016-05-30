/*
 Given a linked list, return the node where the cycle begins. If there is no
cycle, return null .   Note: Do not modify the linked list.   Follow up : Can
you solve it without using extra space?   Subscribe to see which companies asked
this question    Show Tags   Linked List  Two Pointers     Show Similar Problems
(E) Linked List Cycle  (H) Find the Duplicate Number
*/


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 public class Solution {     public ListNode detectCycle(ListNode head) {         if(head==null||head.next==null)return null;         ListNode slow = head, fast = head;         while(fast!=null&&fast.next!=null){             slow = slow.next;             fast = fast.next.next;             if(slow==fast){                 slow=head;                 while(slow!=fast){                     slow = slow.next;                     fast = fast.next;                 }                 return slow;             }         }         return null;     } }
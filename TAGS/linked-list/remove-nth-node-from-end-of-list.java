/*
 Given a linked list, remove the n th node from the end of list and return its
head.  For example,  Given linked list: 1->2->3->4->5 , and n = 2 .
After removing the second node from the end, the linked list becomes 1->2->3->5
.   Note: Given n will always be valid. Try to do this in one pass.   Subscribe
to see which companies asked this question    Show Tags   Linked List  Two
Pointers
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 public class Solution {     public ListNode removeNthFromEnd(ListNode head, int n) {         ListNode dummy = new ListNode(0);         ListNode slow = dummy, fast = dummy;         dummy.next = head;         //move fast n times         for(int i = 0;i<n;i++)fast = fast.next;         //move fast to end, so that slow in at node to delete         while(fast.next!=null){             slow = slow.next;             fast = fast.next;         }         //delete the node         slow.next = slow.next.next;         return dummy.next;     } }
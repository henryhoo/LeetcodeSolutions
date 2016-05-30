/*
 Reverse a singly linked list.  click to show more hints.  Hint:  A linked list
can be reversed either iteratively or recursively. Could you implement both?
Subscribe to see which companies asked this question    Show Tags   Linked List
Show Similar Problems   (M) Reverse Linked List II  (M) Binary Tree Upside Down
(E) Palindrome Linked List
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 public class Solution {
     public ListNode reverseList(ListNode head) {
         if(head==null)return null;
         ListNode prev = null, now = head, next = head.next;
         while(next!=null){
             now.next = prev;
             prev = now;
             now = next;
             next = next.next;
         }
         now.next = prev;
         return now;
     }
 }

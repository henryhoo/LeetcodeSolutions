/*
 Given a list, rotate the list to the right by k places, where k is non-
negative.  For example: Given 1->2->3->4->5->NULL and k = 2 , return
4->5->1->2->3->NULL .   Subscribe to see which companies asked this question
Show Tags   Linked List  Two Pointers     Show Similar Problems   (E) Rotate
Array
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *///My struggle solution
 public class Solution {     public ListNode rotateRight(ListNode head, int k) {         if(head==null || head.next==null)return head;         if(k==0)return head;         ListNode walk = head, newhead = null;         int length = 0;         for(length = 0;walk!=null;length++) {             walk = walk.next;         }         if(k%length==0)return head;         walk = head;         for(int i = 1;i<length-k%length;i++){             walk = walk.next;         }         newhead = walk.next;         walk.next = null;         walk = newhead;         while(walk!=null && walk.next!=null){             walk = walk.next;         }         walk.next = head;         return newhead;     } } //My succinct solution using dummy public class Solution {     public ListNode rotateRight(ListNode head, int k) {         if(head==null || head.next==null)return head;         ListNode dummy = new ListNode(0);         dummy.next = head;         ListNode walk = dummy;         int length = 0;         for(length = 0;walk.next!=null;length++) {             walk = walk.next;         }         walk.next = dummy.next;         walk = head;         for(int i = 1;i<length-k%length;i++){             walk = walk.next;         }         dummy.next = walk.next;         walk.next = null;         return dummy.next;     } }
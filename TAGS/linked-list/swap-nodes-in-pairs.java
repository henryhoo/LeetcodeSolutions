/*
 Given a linked list, swap every two adjacent nodes and return its head.  For
example, Given 1->2->3->4 , you should return the list as 2->1->4->3 .  Your
algorithm should use only constant space. You may not modify the values in the
list, only nodes itself can be changed.   Subscribe to see which companies asked
this question    Show Tags   Linked List     Show Similar Problems   (H) Reverse
Nodes in k-Group
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 public class Solution {     public ListNode swapPairs(ListNode head) {         if(head==null||head.next==null)return head;         ListNode dummy = new ListNode(0);         dummy.next = head;         ListNode walk = dummy, temp=null,temp2=null;         while(walk!=null&&walk.next!=null&&walk.next.next!=null){             temp = walk.next.next.next;             temp2 = walk.next.next;             walk.next.next.next = walk.next;             walk.next.next = temp;             walk.next = temp2;             walk = walk.next.next;         }         return dummy.next;     } }
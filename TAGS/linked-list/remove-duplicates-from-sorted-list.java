/*
 Given a sorted linked list, delete all duplicates such that each element appear
only once .  For example, Given 1->1->2 , return 1->2 . Given 1->1->2->3->3 ,
return 1->2->3 .   Subscribe to see which companies asked this question    Show
Tags   Linked List
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 public class Solution {     public ListNode deleteDuplicates(ListNode head) {         ListNode walk = head;         while(walk!=null){             while(walk.next!=null&&walk.next.val==walk.val){                 walk.next = walk.next.next;             }             walk=walk.next;         }         return head;     } }
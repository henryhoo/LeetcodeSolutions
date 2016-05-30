/*
 Given a linked list and a value x , partition it such that all nodes less than
x come before nodes greater than or equal to x .  You should preserve the
original relative order of the nodes in each of the two partitions.  For
example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5 .   Subscribe
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
 public class Solution {     public ListNode partition(ListNode head, int x) {         ListNode left = new ListNode(0), right = new ListNode(0), walk = head, temp = null;         ListNode h1=left, h2=right;        //head of two parts         while(walk!=null){             temp = walk.next;             if(walk.val<x){                 walk.next = left.next;                 left.next = walk;                 left = left.next;             }             else{                 walk.next = right.next;                 right.next = walk;                 right = right.next;             }             walk = temp;         }         //link two parts         left.next=h2.next;         return h1.next;     } } //2nd time solution public class Solution {    public ListNode partition(ListNode head, int x) {    if(head==null || head.next==null)return head;    ListNode left = new ListNode(0), right = new ListNode(0);    ListNode walk = head, lhead = left, rhead = right;    while(walk!=null){        if(walk.val < x){            left.next = walk;            left = left.next;        }else{            right.next = walk;            right = right.next;        }        walk = walk.next;    }    right.next = null;//important: avoid cycle in the final list    left.next = rhead.next;//link left part to right part    return lhead.next;    }}
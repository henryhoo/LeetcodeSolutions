/*
 Remove all elements from a linked list of integers that have value val .
Example  Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6  Return: 1 --> 2
--> 3 --> 4 --> 5  Credits: Special thanks to @mithmatt for adding this problem
and creating all test cases.   Subscribe to see which companies asked this
question    Show Tags   Linked List     Show Similar Problems   (E) Remove
Element  (E) Delete Node in a Linked List
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *///interative solution
 public class Solution {     public ListNode removeElements(ListNode head, int val) {         if(head==null)return null;         ListNode dummy = new ListNode(0),node = null;         dummy.next=head;         node=dummy;         while(node.next!=null){             if(node.next.val==val){                 node.next=node.next.next;             }             else{             node=node.next;             }         }         return dummy.next;     } } //revursive solution public ListNode removeElements(ListNode head, int val) {    if (head == null) {        return null;    }    ListNode node = removeElements(head.next, val);    if (head.val == val) {        return node;    }    head.next = node;    return head;}
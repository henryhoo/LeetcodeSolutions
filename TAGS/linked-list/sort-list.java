/*
 Sort a linked list in O ( n log n ) time using constant space complexity.
Subscribe to see which companies asked this question    Show Tags   Linked List
Sort     Show Similar Problems   (E) Merge Two Sorted Lists  (M) Sort Colors
(M) Insertion Sort List
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /**  * Definition for singly-linked list.  * public class ListNode {  *     int val;  *     ListNode next;  *     ListNode(int x) { val = x; }  * }  */ public class Solution {     public ListNode sortList(ListNode head) {         ListNode h1 = null, h2 = null, slow = head, fast = head, prev=null;         if(head==null || head.next==null)return head;         //cut current list into two part         while(fast!=null&&fast.next!=null&&fast.next.next!=null){             prev=slow;             slow=slow.next;             fast=fast.next.next;         }         //recursive for 2nd part         h2 = sortList(slow.next);         slow.next=null;         //recursive for 1st part         h1 = sortList(head);         //merge two part         return merge(h1,h2);     }     private ListNode merge(ListNode h1, ListNode h2){         ListNode dummy = new ListNode(-1), p = dummy;         while(h1!=null && h2!=null){             if(h1.val < h2.val){                 p.next = h1;                 h1 = h1.next;             }             else{                 p.next = h2;                 h2 = h2.next;             }             p = p.next;         }         if(h1!=null){             p.next = h1;         }         if(h2!=null){             p.next = h2;         }         return dummy.next;     } }
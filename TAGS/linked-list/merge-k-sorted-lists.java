/*
 Merge k sorted linked lists and return it as one sorted list. Analyze and
describe its complexity.   Subscribe to see which companies asked this question
Show Tags   Divide and Conquer  Linked List  Heap     Show Similar Problems
(E) Merge Two Sorted Lists  (M) Ugly Number II
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /**  * Definition for singly-linked list.  * public class ListNode {  *     int val;  *     ListNode next;  *     ListNode(int x) { val = x; }  * }  */ public class Solution {     public ListNode mergeKLists(ListNode[] lists) {          if(lists.length==0)return null;          //use merge sort to combine each two nodes          int end = lists.length-1, start = 0;          while(end>0){              start = 0;              while(start<end){                  lists[start] = mergeTwoLists(lists[start],lists[end]);                  start++;                  end--;              }          }         return lists[0];     }     private ListNode mergeTwoLists(ListNode l1, ListNode l2) {         if(l1==null)return l2;         if(l2==null)return l1;         ListNode dummy = new ListNode(0), walk = dummy;         while(l1!=null&&l2!=null){             if(l1.val<l2.val){                 walk.next = l1;                 l1 = l1.next;             }else{                 walk.next = l2;                 l2 = l2.next;             }             walk = walk.next;         }         walk.next = l1!=null?l1:l2;         return dummy.next;     } }
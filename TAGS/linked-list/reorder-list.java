/*
 Given a singly linked list L : L 0 → L 1 →…→ L n -1 → L n , reorder it to: L 0
→ L n → L 1 → L n -1 → L 2 → L n -2 →…  You must do this in-place without
altering the nodes' values.  For example, Given {1,2,3,4} , reorder it to
{1,4,2,3} .   Subscribe to see which companies asked this question    Show Tags
Linked List
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 public class Solution {     public void reorderList(ListNode head) {         if(head == null || head.next == null)return;         ListNode slow = head, fast = head;         //find the middle node         while(fast.next!=null && fast.next.next!=null){             slow = slow.next;             fast = fast.next.next;         }         //reverse the second half         ListNode pre = slow.next, cur = pre.next, next = null;         pre.next=null;         while(cur!=null){             next = cur.next;             cur.next = pre;             pre = cur;             cur = next;         }         slow.next = null;         //merge 2 half         cur = pre;         pre = head;         while(cur!=null){             next = cur.next;             cur.next = pre.next;             pre.next = cur;             cur = next;             pre = pre.next.next;         }     } }
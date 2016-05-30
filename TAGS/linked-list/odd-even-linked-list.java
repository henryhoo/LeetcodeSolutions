/*
 Given a singly linked list, group all odd nodes together followed by the even
nodes. Please note here we are talking about the node number and not the value
in the nodes.  You should try to do it in place. The program should run in O(1)
space complexity and O(nodes) time complexity.   Example: Given
1->2->3->4->5->NULL , return 1->3->5->2->4->NULL .   Note: The relative order
inside both the even and odd groups should remain as it was in the input. The
first node is considered odd, the second node even and so on ...  Credits:
Special thanks to @DjangoUnchained for adding this problem and creating all test
cases.   Subscribe to see which companies asked this question    Show Tags
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
 public class Solution {     public ListNode oddEvenList(ListNode head) {         if(head==null)return null;         ListNode next = null, now = head, evenstart = head.next;         int step = 0;         while(now.next!=null && now.next.next!=null){             next = now.next;             now.next = now.next.next;             now = next;             step++;         }         if(step%2==0){             now.next = evenstart;         }         else{             now.next.next = evenstart;             now.next = null;         }         return head;     } } //More succinct solution public class Solution { public ListNode oddEvenList(ListNode head) {     if (head != null) {         ListNode odd = head, even = head.next, evenHead = even;         while (even != null && even.next != null) {             odd.next = odd.next.next;             even.next = even.next.next;             odd = odd.next;             even = even.next;         }         odd.next = evenHead;     }     return head; }}
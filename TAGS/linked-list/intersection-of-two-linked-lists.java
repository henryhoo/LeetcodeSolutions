/*
 Write a program to find the node at which the intersection of two singly linked
lists begins.   For example, the following two linked lists:  A:          a1 →
a2
↘
c1 → c2 → c3
↗
B:     b1 → b2 → b3  begin to intersect at node c1.   Notes:   If the two linked
lists have no intersection at all, return null .  The linked lists must retain
their original structure after the function returns.  You may assume there are
no cycles anywhere in the entire linked structure.  Your code should preferably
run in O(n) time and use only O(1) memory.    Credits: Special thanks to
@stellari for adding this problem and creating all test cases.   Subscribe to
see which companies asked this question    Show Tags   Linked List
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 public class Solution {     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {         ListNode pa=headA,pb=headB;         int la=0,lb=0;         while(pa!=null){             pa=pa.next;             la++;         }         while(pb!=null){             pb=pb.next;             lb++;         }         pa=headA;         pb=headB;         if(la>lb){             for(int j=0;j<la-lb;j++){                 pa=pa.next;             }         }         else{             for(int j=0;j<lb-la;j++){                 pb=pb.next;             }         }         while(pa!=pb){             pa=pa.next;             pb=pb.next;         }         return pa;     } }
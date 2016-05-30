/*
 Given a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list.  For example, Given
1->2->3->3->4->4->5 , return 1->2->5 . Given 1->1->1->2->3 , return 2->3 .
Subscribe to see which companies asked this question    Show Tags   Linked List
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */ if(head==null)return null;
 ListNode dummy = new ListNode(0);
 dummy.next = head;
 ListNode walk = dummy, temp=null;
 int flag = 0;
 while(walk!=null){
     while(walk.next!=null&&walk.next.next!=null&&walk.next.val==walk.next.next.val){
         walk.next.next = walk.next.next.next;
         flag = 1;
     }
     if(flag == 1){
         walk.next = walk.next.next;
     }
     else{
         walk = walk.next;
     }
     flag = 0;
 }
 return dummy.next;
}

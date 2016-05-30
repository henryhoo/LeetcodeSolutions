/*
 Reverse a linked list from position m to n . Do it in-place and in one-pass.
For example: Given 1->2->3->4->5->NULL , m = 2 and n = 4,  return
1->4->3->2->5->NULL .   Note: Given m , n satisfy the following condition: 1 ≤ m
≤ n ≤ length of list.   Subscribe to see which companies asked this question
Show Tags   Linked List     Show Similar Problems   (E) Reverse Linked List
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 public class Solution {
     public ListNode reverseBetween(ListNode head, int m, int n) {
         if(head==null||m==n)return head;
         ListNode prev=null,now=head,next=head.next,begin=null,beginprev=null;
         int step=1;
         while(next!=null){
             if(step>m&&step<n){
                 now.next=prev;
             }
             else if(step==m){
                 begin=now;
                 beginprev=prev;
             }
             else if(step==n){
                 if(m==1){
                     head=now;
                 }
                 else{
                    beginprev.next=now;
                 }
                 now.next=prev;
                 begin.next=next;
             }
             prev=now;
             now=next;
             next=next.next;
             step++;
         }
         if(step==n){
             if(m==1){
                 head=now;
                 }
             else{
                 beginprev.next=now;
                 }
             now.next=prev;
             begin.next=next;
         }
         return head;
     }
 }
//use dummy will be much more succinct
public ListNode reverseBetween(ListNode head, int m, int n) {
    if(head == null) return null;
    ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
    dummy.next = head;
    ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
    for(int i = 0; i<m-1; i++) pre = pre.next;

    ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
    ListNode then = start.next; // a pointer to a node that will be reversed

    // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
    // dummy-> 1 -> 2 -> 3 -> 4 -> 5

    for(int i=0; i<n-m; i++)
    {
        start.next = then.next;
        then.next = pre.next;
        pre.next = then;
        then = start.next;
    }

    // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
    // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

    return dummy.next;

}

//My solution using dummy
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||m==n)return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy, next = null, cur = null, temp = null;
        //find the node before start node
        for(int i = 1;i<m;i++) start = start.next;
        //point for reversing m to n
        cur = start.next;
        next = cur.next;
        //reverse specific part
        for(int i = 0;i<n-m;i++){
            temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }
        //link the joint region
        start.next.next = next;
        start.next = cur;
        return dummy.next;
    }
}

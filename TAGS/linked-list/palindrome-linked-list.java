/*
 Given a singly linked list, determine if it is a palindrome.  Follow up: Could
you do it in O(n) time and O(1) space?   Subscribe to see which companies asked
this question    Show Tags   Linked List  Two Pointers     Show Similar Problems
(E) Palindrome Number  (E) Valid Palindrome  (E) Reverse Linked List
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
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)return true;
        ListNode fast = head, slow = head, mid = slow.next, prev = null;
        //find out the mid point and reverse the 1st part.
        while(fast.next != null&&fast.next.next!=null){
            fast=fast.next.next;
            prev=slow;
            slow=mid;
            mid=slow.next;
            slow.next=prev;
        }
        //deal with odd length situation(slow point to the middle and let it point to its next in order to align)
        if(fast.next==null){
            slow=slow.next;
        }
        //check 1st and 2nd part to see if Palindrome
        while(mid!=null){
            if(mid.val!=slow.val)return false;
            mid=mid.next;
            slow=slow.next;
        }
        return true;
    }
}

//2ND TIME Solutionpublic class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)return true;
        ListNode fast = head, slow = head, pre = null, temp = null;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        slow = pre;
        temp = fast==null?temp:temp.next;
        while(temp!=null){
            if(temp.val!=slow.val)return false;
            temp = temp.next;
            slow = slow.next;
        }
        return true;
    }
}

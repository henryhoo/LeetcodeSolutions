/*
 Given a singly linked list where elements are sorted in ascending order,
convert it to a height balanced BST.   Subscribe to see which companies asked
this question    Show Tags   Depth-first Search  Linked List     Show Similar
Problems   (M) Convert Sorted Array to Binary Search Tree
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */ public class Solution {
     public TreeNode sortedListToBST(ListNode head) {
         if(head==null) return null;
         return toBST(head,null);
     }
     private TreeNode toBST(ListNode head, ListNode tail){
         if(head==tail) return null;
         ListNode slow = head, fast = head;
         while(fast!=tail&&fast.next!=tail){
             slow=slow.next;
             fast=fast.next.next;
         }
         TreeNode root = new TreeNode(slow.val);
         root.left = toBST(head,slow);
         root.right = toBST(slow.next,tail);
         return root;
     }
 }

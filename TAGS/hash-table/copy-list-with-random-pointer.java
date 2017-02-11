/*
 A linked list is given such that each node contains an additional random
pointer which could point to any node in the list or null.  Return a deep copy
of the list.   Subscribe to see which companies asked this question    Show Tags
Hash Table  Linked List     Show Similar Problems   (M) Clone Graph
*/


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 /**  * Definition for singly-linked list with a random pointer.  * class RandomListNode {  *     int label;  *     RandomListNode next, random;  *     RandomListNode(int x) { this.label = x; }  * };  */ public class Solution {     public RandomListNode copyRandomList(RandomListNode head) {         HashMap<RandomListNode, RandomListNode> map = new HashMap<>();         RandomListNode node = head;         while (node != null) {             map.put(node, new RandomListNode(node.label));             node = node.next;         }         node = head;         while (node != null) {             map.get(node).next = map.get(node.next);             map.get(node).random = map.get(node.random);             node = node.next;         }         return map.get(head);     } }
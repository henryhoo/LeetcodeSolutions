/*
 Given a binary tree, return the preorder traversal of its nodes' values.  For
example: Given binary tree {1,#,2,3} ,  1
\
2
/
3   return [1,2,3] .  Note: Recursive solution is trivial, could you do it
iteratively?   Subscribe to see which companies asked this question    Show Tags
Tree  Stack     Show Similar Problems   (M) Binary Tree Inorder Traversal  (M)
Verify Preorder Sequence in Binary Search Tree
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 public class Solution {     public List<Integer> preorderTraversal(TreeNode root) {         if (root == null)             return new LinkedList<>();         else {             List<Integer> res = new LinkedList<>();             res.add(root.val);             res.addAll(preorderTraversal(root.left));             res.addAll(preorderTraversal(root.right));             return res;         }     } }
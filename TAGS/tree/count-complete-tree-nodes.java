/*
 Given a complete binary tree, count the number of nodes.  Definition of a
complete binary tree from Wikipedia : In a complete binary tree every level,
except possibly the last, is completely filled, and all nodes in the last level
are as far left as possible. It can have between 1 and 2 h nodes inclusive at
the last level h.   Subscribe to see which companies asked this question    Show
Tags   Tree  Binary Search     Show Similar Problems   (E) Closest Binary Search
Tree Value
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
 public class Solution {     public int countNodes(TreeNode root) {         if (root == null) return 0;         TreeNode left = root;         TreeNode right = root;         int height = 0;         while (right != null) {             right = right.right;             left = left.left;             height++;         }         if (left == null)             return (1 << height) - 1;         return 1 + countNodes(root.left) + countNodes(root.right);     } }
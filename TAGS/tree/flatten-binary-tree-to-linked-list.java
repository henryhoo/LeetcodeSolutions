/*
 Given a binary tree, flatten it to a linked list in-place.  For example, Given
1
/ \
2   5
/ \   \
3   4   6  The flattened tree should look like:  1
\
2
\
3
\
4
\
5
\
6  click to show hints.  Hints:  If you notice carefully in the flattened tree,
each node's right child points to the next node of a pre-order traversal.
Subscribe to see which companies asked this question    Show Tags   Tree  Depth-
first Search
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *///my first solution 34%
 public class Solution {     public void flatten(TreeNode root) {         root = flat(root);     }     private TreeNode flat(TreeNode root){         if(root == null) return null;         TreeNode temp = root.right;         root.right = flat(root.left);         root.left = null;         TreeNode temp2 = root;         while(temp2.right != null){             temp2 = temp2.right;         }         temp2.right = flat(temp);         return root;     } }
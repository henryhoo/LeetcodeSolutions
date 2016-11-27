/*
 Given inorder and postorder traversal of a tree, construct the binary tree.
Note: You may assume that duplicates do not exist in the tree.   Subscribe to
see which companies asked this question    Show Tags   Tree  Array  Depth-first
Search     Show Similar Problems   (M) Construct Binary Tree from Preorder and
Inorder Traversal
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
 public class Solution {     public TreeNode buildTree(int[] inorder, int[] postorder) {        	if (inorder == null || postorder == null || inorder.length != postorder.length) 		    return null; 		HashMap<Integer, Integer> map = new HashMap<>(); 		for (int i = 0; i < inorder.length; i++) { 		    map.put(inorder[i], i); 		} 		return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);     }     private TreeNode helper(int[]inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer,Integer> map) {         if (is > ie || ps > pe) return null;         int mid = map.get(postorder[pe]);         TreeNode node = new TreeNode(postorder[pe]);         node.left = helper(inorder, is, mid - 1, postorder, ps, ps + mid - is - 1, map);         node.right = helper(inorder, mid + 1, ie, postorder, ps + mid - is, pe - 1, map);         return node;     } }
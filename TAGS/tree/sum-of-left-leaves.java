public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, 0);
    }
    private int helper(TreeNode root, int flag) {
        if (root == null) return 0;
        else if (flag == 1 && root.right == null && root.left == null) return root.val;
        else {
            int right = helper(root.right, 0);
            int left = helper(root.left, 1);
            return right + left;
        }
    }
}

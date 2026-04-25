/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return process(root, Integer.MIN_VALUE);
    }

    private int process(TreeNode node, int max) {
        if (node == null)
            return 0;
        int count = (node.val < max) ? 0 : 1;
        max = Math.max(node.val, max);
        return count + process(node.left, max) + process(node.right, max);
    }
}

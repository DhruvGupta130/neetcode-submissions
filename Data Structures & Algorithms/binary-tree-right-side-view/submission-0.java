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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return List.of();
        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.offer(root);

        List<Integer> res = new ArrayList<>();

        while (!qu.isEmpty()) {
            int size = qu.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = qu.poll();
                if (i == size - 1) {
                    res.add(node.val);
                }
                if (node.left != null) qu.offer(node.left);
                if (node.right != null) qu.offer(node.right);
            }
        }

        return res;
    }
}

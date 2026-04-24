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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();
        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.offer(root);

        List<List<Integer>> res = new ArrayList<>();

        while (!qu.isEmpty()) {
            int size = qu.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode poll = qu.poll();
                list.add(poll.val);
                if (poll.left != null) qu.offer(poll.left);
                if (poll.right != null) qu.offer(poll.right);
            }
            res.add(list);
        }

        return res;
    }
}

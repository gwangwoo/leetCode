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
    public static int sumOfLeftLeaves(TreeNode root) {
        int answer = 0;
        if (root.left != null) {
            answer += go(root.left, true);
        }

        if (root.right != null) {
            answer += go(root.right, false);
        }

        return answer;
    }

    public static int go(TreeNode node, boolean isLeft) {
        int answer = 0;
        if (node.left == null && node.right == null) {
            if (isLeft) {
                return node.val;
            }
            return 0;
        }

        if (node.left != null) {
            answer += go(node.left, true);
        }
        if (node.right != null) {
            answer += go(node.right, false);
        }
        return answer;
    }
}
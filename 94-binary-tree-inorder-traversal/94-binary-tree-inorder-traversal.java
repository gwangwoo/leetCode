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
import java.util.*;
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> answer = new ArrayList<>();        
        go(root, answer);
        return answer;
    }
    
    public void go(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }
        
        if(node.left != null) go(node.left, list);
        list.add(node.val);
        if(node.right != null) go(node.right, list);
        return;
    } 
}
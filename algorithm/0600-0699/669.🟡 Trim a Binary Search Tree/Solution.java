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

    int max, min;

    public TreeNode trimBST(TreeNode root, int low, int high) {
        max = high;
        min = low;
        return dfs(root);
    }

    public TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode lNode = dfs(node.left);
        TreeNode rNode = dfs(node.right);
        int val = node.val;
        if (val <= max && val >= min) {
            node.left = lNode;
            node.right = rNode;
            return node;
        }
        return lNode == null ? rNode : lNode;
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
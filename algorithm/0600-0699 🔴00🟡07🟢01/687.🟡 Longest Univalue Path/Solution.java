import java.util.HashMap;
import java.util.Map;

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

    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = dfs(node.left);
        int r = dfs(node.right);
        int lMax = 0, rMax = 0;
        if (node.left != null && node.left.val == node.val) {
            lMax = l + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            rMax = r + 1;
        }
        max = Math.max(max, lMax + rMax);
        return Math.max(lMax, rMax);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, 
            new TreeNode(5, new TreeNode(5), new TreeNode(1)),
            new TreeNode(5, null, new TreeNode(5)));
        new Solution().longestUnivaluePath(root);
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
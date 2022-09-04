class Solution {

    int maxDeep, count;

    public int deepestLeavesSum(TreeNode root) {

        next(root, maxDeep);

        return count;
    }

    public void next(TreeNode node, int deep) {
        if (node.left == null && node.right == null) {
            if (deep < maxDeep) {
                return;
            }
            if (deep > maxDeep) {
                count = 0;
                maxDeep = deep;
            }
            count += node.val;
            return;
        }
        deep++;
        if (node.left != null) {
            next(node.left, deep);
        }
        if (node.right != null) {
            next(node.right, deep);
        }
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
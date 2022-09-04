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

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root.val < val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        TreeNode node = root;
        while(true) {
            if (node == null) {
                break;
            }
            TreeNode right = node.right;
            if (right == null) {
                TreeNode insert = new TreeNode(val, null, right);
                node.right = insert;
                break;
            } else {
                if (right.val > val) {
                    node = right;
                    continue;
                } else {
                    TreeNode insert = new TreeNode(val, right, null);
                    node.right = insert;
                    break;
                }
            }
        }
        return root;
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
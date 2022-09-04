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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return nextDepth(nums, 0, nums.length - 1);
    }

    public TreeNode nextDepth(int[] nums, int start, int end) {
        int max = -1;
        int maxPos = -1;
        for (int i = start; i < end + 1; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxPos = i;
            }
        }
        if (maxPos >= 0) {        
            TreeNode node = new TreeNode(max);
            node.left = nextDepth(nums, start, maxPos - 1);
            node.right = nextDepth(nums, maxPos + 1, end);
            return node;
        }
        return null;
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
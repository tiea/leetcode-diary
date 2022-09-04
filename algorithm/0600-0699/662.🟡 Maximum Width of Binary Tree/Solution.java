import java.util.ArrayList;
import java.util.List;

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

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1);
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int max = 0;
        int size = list.size();
        while (size > 0) {
            int width = list.get(size - 1).val - list.get(0).val + 1;
            max = Math.max(max, width);
            List<TreeNode> tmpList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = list.get(i);
                if (node.left != null) {
                    tmpList.add(node.left);
                }
                if (node.right != null) {
                    tmpList.add(node.right);
                }
            }
            list = tmpList;
            size = list.size();
        }
        return max;
    }
    
    public void dfs(TreeNode node, int pos) {
        if (node == null) {
            return;
        }
        node.val = pos;
        dfs(node.left, pos * 2 - 1);
        dfs(node.right, pos * 2);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
            new TreeNode(3, new TreeNode(5), new TreeNode(3)),
            new TreeNode(2, null, new TreeNode(9)));
        new Solution().widthOfBinaryTree(root);
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
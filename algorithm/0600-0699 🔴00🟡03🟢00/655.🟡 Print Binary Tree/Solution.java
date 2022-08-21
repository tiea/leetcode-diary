import java.util.List;
import java.util.ArrayList;

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

    int height;
    int width;

    public List<List<String>> printTree(TreeNode root) {
        height = next(root, 0) + 1;
        List<List<String>> array2d = new ArrayList<>(height + 1);
        width = (1 << height) - 1;
        buildNode(root, 0, -1, array2d, true);
        return array2d;
    }

    public int next(TreeNode root, int depth) {
        if (root == null) {
            return depth - 1;
        }
        depth++;
        int lDepth = next(root.left, depth);
        int rDepth = next(root.right, depth);
        return Math.max(lDepth, rDepth);
    }
    
    public void buildNode(TreeNode root, int depth, int y, List<List<String>> array2d, boolean left) {
        if (root == null) {
            return;
        }
        int val = root.val;
        List<String> rowList = null;
        if (array2d.size() <= depth) {
            rowList = new ArrayList<>(width);
            for (int i = 0; i < width; i++) {
                rowList.add("");
            }
            array2d.add(rowList);
        } else {
            rowList = array2d.get(depth);
        }
        if (depth == 0) {
            y = (width - 1) / 2;
        } else {
            if (left) {
                y = y - (1 << (height - depth - 1));
            } else {
                y = y + (1 << (height - depth - 1));
            }
        }
        rowList.set(y, val + "");
        buildNode(root.left, depth + 1, y, array2d, true);
        buildNode(root.right, depth + 1, y, array2d, false);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        new Solution().printTree(root);
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
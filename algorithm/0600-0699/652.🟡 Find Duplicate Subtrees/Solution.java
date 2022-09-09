import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    List<TreeNode> ans = new ArrayList<>();
    
    Map<String, Integer> map = new HashMap<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    public StringBuffer dfs(TreeNode node) {
        if (node == null) {
            return new StringBuffer();
        }
        StringBuffer path = new StringBuffer().append(node.val).append(",");
        StringBuffer l = dfs(node.left);
        StringBuffer r = dfs(node.right);
        path.append(l).append(",").append(r);
        String key = path.toString();
        Integer count = map.getOrDefault(key, 0);
        if (count == 1) {
            ans.add(node);
        }
        map.put(key, ++count);
        return path;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, 
            new TreeNode(2, new TreeNode(4), null),
            new TreeNode(3, new TreeNode(2, new TreeNode(4), null), 
            new TreeNode(4)) );
        new Solution().findDuplicateSubtrees(root);
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
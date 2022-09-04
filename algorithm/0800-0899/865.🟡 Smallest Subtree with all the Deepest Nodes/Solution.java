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
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        List<TreeNode> list = new ArrayList<>();
        Map<Integer, TreeNode> parentMap = new HashMap<>();
        list.add(root);
        while (true) {
            int len = list.size();
            List<TreeNode> tmpList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = list.get(i);
                if (node.left != null) {
                    parentMap.put(node.left.val, node);
                    tmpList.add(node.left);
                }
                if (node.right != null) {
                    parentMap.put(node.right.val, node);
                    tmpList.add(node.right);
                }
            }
            if (tmpList.isEmpty()) {
                break;
            }
            list = tmpList;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        TreeNode ans = null;
        while (true) {
            int len = list.size();
            List<TreeNode> tmpList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                tmpList.add(parentMap.get(list.get(i).val));
            }
            boolean allSame = true;
            int val = tmpList.get(0).val;
            for (int i = 1; i < len; i++) {
                if (val != tmpList.get(i).val) {
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
                ans = tmpList.get(0);
                break;
            }
            list = tmpList;
        }
        return ans;
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
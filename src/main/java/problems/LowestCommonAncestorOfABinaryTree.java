package problems;

import java.util.*;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * Medium
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 * <p>
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 * <p>
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 */
public class LowestCommonAncestorOfABinaryTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        HashMap<TreeNode, TreeNode> dp = new HashMap<>();
        dp.put(root, null);

        while (!dp.containsKey(p) || !dp.containsKey(q)) {
            TreeNode node = stack.pop();

            if (node.left != null) {
                stack.push(node.left);
                dp.put(node.left, node);
            }

            if (node.right != null) {
                stack.push(node.right);
                dp.put(node.right, node);
            }
        }

        Set<TreeNode> parentNode = new HashSet<>();
        while (p != null){
            parentNode.add(p);
            p = dp.get(p);
        }

        while (!parentNode.contains(q)){
            q = dp.get(q);
        }

        return q;
    }
}

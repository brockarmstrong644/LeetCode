// Accepted and Run with a runtime of 0ms
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true; // an empty tree is symmetric
        return isMirror(root.left, root.right); // the tree is symmetric when its two halves mirror each other
    }

    private boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true; // both spots empty: match
        if (a == null || b == null) return false; // only one spot empty: mismatch
        if (a.val != b.val) return false; // both exist but values differ

        // Outer pair and inner pair must both be mirrors
        return isMirror(a.left, b.right) // outer: left side's left vs right side's right
            && isMirror(a.right, b.left); // inner: left side's right vs right side's left
    }
}

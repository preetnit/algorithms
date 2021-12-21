package com.algos.treesAndGraph;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 */
public class KthSmallestElementBST {

    public static void main(String[] args) {
        TreeNode root =
                new TreeNode(4,
                        new TreeNode(2,
                                null, new TreeNode(3)),
                        new TreeNode(7));

        KthSmallestElementBST kse = new KthSmallestElementBST();
        System.out.println(kse.kthSmallest(root, 3));
    }

    int smallest = 0;
    int result = -1;
    boolean found;

    public int kthSmallest(TreeNode root, int k) {
        if(found) return result;
        if(root == null) return result;

        kthSmallest(root.left, k);
        if(k == ++smallest) {
            found = true;
            result = root.val;
            return result;
        }
        kthSmallest(root.right, k);
        return result;
    }
}

package com.algos.treesAndGraph;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 *
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 *
 */
public class PopulatingNextRightPointersEachNode {

    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode next;

        public TreeNode() {}

        public TreeNode(int _val) {
            val = _val;
        }

        public TreeNode(int _val, TreeNode _left, TreeNode _right) {
            val = _val;
            left = _left;
            right = _right;
            next = null;
        }

        public TreeNode(int _val, TreeNode _left, TreeNode _right, TreeNode _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersEachNode pnpn = new PopulatingNextRightPointersEachNode();

        TreeNode root =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4,
                                        new TreeNode(8),
                                        new TreeNode(9)),
                                new TreeNode(5,
                                        new TreeNode(10),
                                        new TreeNode(11))),
                        new TreeNode(3,
                                new TreeNode(6,
                                        new TreeNode(12),
                                        new TreeNode(13)),
                                new TreeNode(7,
                                        new TreeNode(14),
                                        new TreeNode(15))));
        pnpn.connect(root);
        System.out.println("Done");
    }

    public TreeNode connect(TreeNode root) {
        if(root == null) return null;
        root.next = null;
        return connectNext(root);
    }

    public TreeNode connectNext(TreeNode node) {
        if(node == null) return null;
        if(node.left != null)
            node.left.next = node.right;
        if(node.right != null)
            node.right.next = node.next != null ? node.next.left: null;
        connectNext(node.left);
        connectNext(node.right);
        return node;
    }
}

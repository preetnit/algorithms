package com.algos.treesAndGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));

        BinaryTreeInorderTraversal btit  = new BinaryTreeInorderTraversal();
        List<Integer> result = btit.inorderTraversal(root);
        result.stream().forEach(System.out::println);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode node, List<Integer> result) {
        if(node != null) {
            inorderTraversal(node.left, result);
            result.add(node.val);
            inorderTraversal(node.right, result);
        }
    }

}

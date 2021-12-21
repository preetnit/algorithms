package com.algos.treesAndGraph;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 * Constraints:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        int[] preorder = {3,9,10,11,20,15,7};
        int[] inorder = {10,9,11,3,15,20,7};
        /*int[] preorder = {1,2,3};
        int[] inorder = {3,2,1};*/
        //int[] preorder = {1,2};
        //int[] inorder = {1,2};
        ConstructBinaryTreeFromPreorderAndInorderTraversal cbtpi =
                new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        TreeNode root = cbtpi.buildTree(preorder, inorder);
        System.out.println("Done");
    }

    /*public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
        if(preorder.length == 1)
            return new TreeNode(preorder[0]);

        TreeNode root = new TreeNode(preorder[0]);
        int i,p=0;

        Set<Integer> leftSet = new HashSet<>();
        for(i=0; i<inorder.length && preorder[0] != inorder[i]; i++)
            leftSet.add(inorder[i]);

        if(i>0) {
            for(p=1; p<preorder.length && leftSet.contains(preorder[p]); p++);

            root.left = buildTree(Arrays.copyOfRange(preorder, 1, p),
                    Arrays.copyOfRange(inorder, 0, i));


        }else
            root.left = null;

        p = p==0 ? p+1: p;
        root.right = buildTree(Arrays.copyOfRange(preorder, p, preorder.length),
                Arrays.copyOfRange(inorder, i+1, inorder.length));
        return root;
    }*/

    private int inorderIndex = 0;
    private int preorderIndex = 0;
    // PreOrder: Root -> Left -> Right
    // Root = preorder[0];
    // InOrder: Left -> Root -> Right
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

/*    int[] preorder = {3,9,10,11,20,15,7};
    int[] inorder = {10,9,11,3,15,20,7};*/
    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (preorderIndex >= preorder.length) return null;
        if (inorder[inorderIndex] == stop) {
            inorderIndex++;
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderIndex++]);
        root.left = build(preorder, inorder, root.val);
        root.right = build(preorder, inorder, stop);
        return root;
    }
}

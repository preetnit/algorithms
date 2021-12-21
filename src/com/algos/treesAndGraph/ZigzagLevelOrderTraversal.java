package com.algos.treesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.algos.utils.Utils.printListOfList;


/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 *
 * Input: root = [1]
 * Output: [[1]]
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 */
public class ZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        zigzagLevelOrder(root, 0, result);
        return result;
    }

    public void zigzagLevelOrder(TreeNode root, int level, List<List<Integer>> result) {

        if(root != null) {
            if(result.size() <= level) {
                List<Integer> nodes = new LinkedList();
                result.add(nodes);
            }
            if(level%2==0)
                ((LinkedList)result.get(level)).addLast(root.val);
            else
                ((LinkedList)result.get(level)).addFirst(root.val);
            zigzagLevelOrder(root.left, level+1, result);
            zigzagLevelOrder(root.right, level+1, result);
        }
    }

    public static void main(String[] args) {
        TreeNode root =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4,
                                        new TreeNode(8), null),
                                new TreeNode(5,
                                        null, new TreeNode(9))),
                        new TreeNode(3,
                                new TreeNode(6,
                                        null, new TreeNode(10)),
                                new TreeNode(7,
                                        new TreeNode(11), null)));

        ZigzagLevelOrderTraversal zlot = new ZigzagLevelOrderTraversal();
        List<List<Integer>> result = zlot.zigzagLevelOrder(root);
        printListOfList(result);
    }
}

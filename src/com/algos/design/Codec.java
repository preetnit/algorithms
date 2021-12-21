package com.algos.design;

import com.algos.treesAndGraph.TreeNode;

public class Codec {
    public static void main(String[] args) {
        TreeNode root =
                new TreeNode(4,
                        new TreeNode(2,
                                null, new TreeNode(3)),
                        new TreeNode(7));
        Codec codec = new Codec();
        String ser = codec.serialize(root);
        System.out.println("SERIALIZE :: "+ser);

        TreeNode rootD = codec.deserialize(ser);
        System.out.println(rootD);
    }

    final String SPLITTER = ",";
    final String NULL = "null";
        
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.deleteCharAt(0).toString();
    }
    
    void serialize(TreeNode node, StringBuilder sb) {
        if(node == null)
            sb.append(SPLITTER+NULL); 
        else {
            sb.append(SPLITTER+node.val); 
            serialize(node.left, sb);
            serialize(node.right, sb);
        }
    }

    int counter = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeList = data.split(SPLITTER);
        counter = 0;
        return buildTree(nodeList);
    }

    private TreeNode buildTree(String[] nodeList) {
        TreeNode node = null;
        if(counter < nodeList.length && !nodeList[counter].equals(NULL)) {
            node = new TreeNode(Integer.valueOf(nodeList[counter]));
            ++counter;
            node.left = buildTree(nodeList);
            ++counter;
            node.right = buildTree(nodeList);
        }
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
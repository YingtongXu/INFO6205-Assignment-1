package org.example;

public class LC366FindLeavesOfBinaryTree {

//    https://leetcode.com/problems/find-leaves-of-binary-tree/
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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        while(root != null){
            List<Integer> list = new ArrayList<>();
            root = removeLeaves(root,list);
            res.add(list);
        }
        return res;
    }

    private TreeNode removeLeaves(TreeNode root, List<Integer> temp){
        if(root == null) return null;
        if(root.left == null && root.right == null){
            temp.add(root.val);
            return null;
        }
        root.left = removeLeaves(root.left, temp);
        root.right = removeLeaves(root.right, temp);
        return root;
    }
}

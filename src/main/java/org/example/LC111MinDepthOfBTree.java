package org.example;

public class LC111MinDepthOfBTree {

//    https://leetcode.com/problems/minimum-depth-of-binary-tree/
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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return bfs(root,1);
    }

    private int bfs(TreeNode node, int count){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                size --;
                node = q.poll();
                if(node.left == null && node.right == null) return count;
                if(node.left != null)q.offer(node.left);
                if(node.right != null)q.offer(node.right);
            }
            count++;
        }
        return -1;
    }
}

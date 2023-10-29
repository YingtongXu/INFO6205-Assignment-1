package org.example;

public class LC1302DeepestLeavesSum {

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
    public int deepestLeavesSum(TreeNode root) {
        return calculate(root, 0);
    }

    private int calculate(TreeNode node, int sum) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            sum = 0;
            int size = queue.size();
            while(size != 0){
                size --;
                TreeNode temp = queue.poll();
                sum += temp.val;
                if(temp.left != null) queue.offer(temp.left);
                if(temp.right != null) queue.offer(temp.right);
            }
        }
        return sum;
    }
}

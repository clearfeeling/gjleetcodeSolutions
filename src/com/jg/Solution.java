package com.jg;


import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        Map<TreeNode,Integer> treeNodeIntegerMap = new HashMap<>();

        return robTry(root,treeNodeIntegerMap);
    }

    public int robTry(TreeNode node,Map<TreeNode,Integer> map){
        int result1 = 0;
        if(null==node)
            return result1;
        if(map.containsKey(node))
            return map.get(node);
        result1 += node.val;
        if(null!=node.left)
            result1+=robTry(node.left.left,map)+robTry(node.left.right,map);
        if(null!=node.right)
            result1+=robTry(node.right.left,map)+robTry(node.right.right,map);
        int result2 = robTry(node.left,map)+robTry(node.right,map);
        int result = Math.max(result1,result2);
        map.put(node,result);
        return result;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(3);

        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(5);

        root.left = left;
        root.right = right;

        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(3);

        TreeNode right2 = new TreeNode(1);

        left.left = left1;
        left.right = right1;
        right.right = right2;

        System.out.println(solution.rob(root));
    }
}



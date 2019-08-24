package com_yuanfudao;

import DataStructure.TreeNode;

/**
 * leetcode236
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */

public class leetcode236 {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }
    private int dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return 0;
        int left = dfs(root.left, p, q);
        int right = dfs(root.right, p, q);
        int mid = root == p || root == q ? 1 : 0;
        if(left + right + mid > 1) res = root;
        return left + right + mid > 0 ? 1 : 0;
    }
}

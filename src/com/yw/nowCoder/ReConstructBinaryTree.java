package com.yw.nowCoder;

//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
//假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

public class ReConstructBinaryTree {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstruct(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    //递归思想，每次将左右两颗子树当成新的子树进行处理，中序的左右子树索引很好找，前序的开始结束索引通过计算中序中左右子树的大小来计算，然后递归求解
    // 直到startPre>endPre||startIn>endIn说明子树整理完到。方法每次返回左子树活右子树的根节点
    public TreeNode reConstruct(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if(startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (pre[startPre] == in[i]) {
                root.left = reConstruct(pre, startPre + 1, i + startPre - startIn, in, startIn, i - 1);
                root.right = reConstruct(pre, i + 1 + startPre - startIn, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
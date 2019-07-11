package com.yw.dataStructure.binarySortTree;

class TreeNode {
    private int data;
    private TreeNode leftChild = null;
    private TreeNode rightChild = null;

    TreeNode() {
    }

    TreeNode(int data) {
        this.data = data;
    }


    TreeNode(int data, TreeNode leftChild, TreeNode rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

}


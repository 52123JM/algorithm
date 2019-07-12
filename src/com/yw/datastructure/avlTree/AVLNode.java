package com.yw.datastructure.avlTree;

class AvlNode {
    private int value;
    private AvlNode left = null;
    private AvlNode right = null;
    private int height;

    public AvlNode(int value) {
        this.value = value;
    }

    public AvlNode() {

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public AvlNode getLeft() {
        return left;
    }

    public void setLeft(AvlNode left) {
        this.left = left;
    }

    public AvlNode getRight() {
        return right;
    }

    public void setRight(AvlNode right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}


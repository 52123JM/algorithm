package com.yw.dataStructure.avlTree;

public class AVLTree {

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 6, 9, 8, 7, 2, 4};
        AvlNode node = new AvlNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
             node = insert(arr[i],node);
        }

        inTraverseTree(node);

    }

    //中序遍历
    private static void inTraverseTree(AvlNode node) {
        if (node != null) {
            inTraverseTree(node.getLeft());
            System.out.println(node.getValue());
            inTraverseTree(node.getRight());
        }
    }

    //树的高度
    private static int getHeight(AvlNode node) {
        if (node == null) return -1;
        else return node.getHeight();
    }

    public static AvlNode insert(int value, AvlNode node) {
        if (node == null) {
            node = new AvlNode(value);
        } else if (value < node.getValue()) {
            //左子树继续比较
            node.setLeft(insert(value, node.getLeft()));
            //左右子树高度差2
            if (getHeight(node.getLeft()) - getHeight(node.getRight()) == 2) {
                if (value < node.getLeft().getValue()) {
                    node = R_Rotate(node); //左左型，右旋调整
                } else {
                    node = L_R_Rotate(node); //左右型，左右旋调整
                }
            }
        } else if(value > node.getValue()){
            node.setRight(insert(value, node.getRight()));
            if (getHeight(node.getRight()) - getHeight(node.getLeft()) == 2) {
                if (value > node.getRight().getValue()) {
                    node = L_Rotate(node); //右右型，左旋调整
                } else {
                    node = R_L_Rotate(node); //右左型，右左旋调整
                }
            }
        }
        node.setHeight(Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
        return node;
    }

    private static AvlNode R_L_Rotate(AvlNode node) {
        node = R_Rotate(node.getRight());
        return L_Rotate(node);
    }

    private static AvlNode L_R_Rotate(AvlNode node) {
        node = L_Rotate(node.getLeft());
        return R_Rotate(node);
    }

    private static AvlNode L_Rotate(AvlNode node) {
        AvlNode newNode = node.getRight();
        node.setRight(newNode.getLeft());
        newNode.setLeft(node);

        //重新计算高度
        node.setHeight(Math.max(getHeight(node.getLeft()),getHeight(node.getRight())) + 1);
        newNode.setHeight(Math.max(getHeight(newNode.getLeft()),getHeight(newNode.getRight())) + 1);
        return newNode;
    }

    private static AvlNode R_Rotate(AvlNode node) {
        AvlNode newNode = node.getLeft();
        node.setLeft(newNode.getRight());
        newNode.setRight(node);

        //重新计算高度
        node.setHeight(Math.max(getHeight(node.getLeft()),getHeight(node.getRight())) + 1);
        newNode.setHeight(Math.max(getHeight(newNode.getLeft()),getHeight(newNode.getRight())) + 1);
        return newNode;
    }
}



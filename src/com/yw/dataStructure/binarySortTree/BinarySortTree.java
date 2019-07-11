package com.yw.dataStructure.binarySortTree;

public class BinarySortTree {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 6, 9, 8, 7, 2, 4};
        TreeRoot treeRoot = new TreeRoot();
        for (int data : arr) {
            creaTree(treeRoot, data);
        }

        inTraverseTree(treeRoot.getRootNode());

    }

    private static void creaTree(TreeRoot treeRoot, int data) {

        if (treeRoot.getRootNode() == null) {
            treeRoot.setRootNode(new TreeNode(data));
        } else {
            TreeNode tmp = treeRoot.getRootNode();

            while (tmp != null) {
                if (data > tmp.getData()) {
                    if (tmp.getRightChild() == null) {
                        tmp.setRightChild(new TreeNode(data));
                        return;
                    } else {
                        tmp = tmp.getRightChild();
                    }
                }else{
                    if (tmp.getLeftChild() == null) {
                        tmp.setLeftChild(new TreeNode(data));
                        return;
                    } else {
                        tmp = tmp.getLeftChild();
                    }
                }
            }
        }
    }

    private static void inTraverseTree(TreeNode node) {
        if (node != null) {
            inTraverseTree(node.getLeftChild());
            System.out.println(node.getData());
            inTraverseTree(node.getRightChild());
        }
    }

}

//用一个类来表示根节点
class TreeRoot {
    private TreeNode rootNode = null;

    public TreeNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(TreeNode rootNode) {
        this.rootNode = rootNode;
    }
}


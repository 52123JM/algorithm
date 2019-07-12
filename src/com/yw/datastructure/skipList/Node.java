package com.yw.datastructure.skipList;

class Node {
    int value;
    int level; //层数
    Node[] next;

    public Node(int value, int level) {
        this.value = value;
        this.level = level;
        this.next = new Node[level];
    }
}

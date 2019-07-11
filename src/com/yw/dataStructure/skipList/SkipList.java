package com.yw.dataStructure.skipList;

//跳跃表
public class SkipList {
    int maxLevel = 16;//允许的最大层数
    Node head = new Node(-1, 16);//头节点
    int size = 0; //元素个数
    int levelCount = 1; //当前层数

    public Node find(int value) {
        Node tmp = head;
        for (int i = levelCount - 1; i >= 0; i--) { //从最顶层开始查找
            while (tmp.next[i] != null && tmp.next[i].value < value) {
                tmp = tmp.next[i];
            }
            //进入下一层，继续比较
        }
        if (tmp.next[0] != null && tmp.next[0].value == value) {
            return tmp.next[0];
        } else {
            return null;
        }
    }

    public void insert(int value) {
        int level = getLevel(); //随机计算插入节点层数
        Node newNode = new Node(value,level);
        Node[] update = new Node[level];
        Node tmp = head;

        //找出每层插入位置存到update[]
        for(int i = level-1; i>=0;i--){
            while (tmp.next[i] != null && tmp.next[i].value < value) {
                tmp = tmp.next[i];
            }
            update[i] = tmp;
        }

        //插入
        for (int i = 0; i < level; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }

        //重新计算当前层数
        if(level > levelCount) levelCount = level;
        size++;

    }

    public void delete(int value){
        Node tmp = head;
        Node[] update = new Node[levelCount];

        //找出删除位置
        for (int i = levelCount - 1; i >= 0; i--) {
                while (tmp.next[i] != null && tmp.next[i].value < value) {
                    tmp = tmp.next[i];
                }
                update[i] = tmp;
        }

        //删除
        if(update[0].next[0] != null && update[0].next[0].value == value){
            for (int i = 0; i < levelCount; i++) {
                if(update[i].next[i] != null && update[i].next[i].value == value){
                    update[i].next[i] = update[i].next[i].next[i];
                }

            }
            size--;
        }

    }

    public void print(){
        Node tmp = head;
        while(tmp.next[0] != null){
            System.out.println(tmp.next[0].value);
            tmp = tmp.next[0];
        }
    }

    //用抛硬币的方式决定插入节点的层数
    private int getLevel() {
        int level = 1;
        while (true) {
            int t = (int) (Math.random() * 100);
            if (t % 2 == 0) {
                level++;
            } else {
                break;
            }
        }
        return level;
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        for (int i = 0; i < 6; i++) {
            skipList.insert(i);
        }
        skipList.print();
        skipList.delete(4);
        skipList.print();
    }

}


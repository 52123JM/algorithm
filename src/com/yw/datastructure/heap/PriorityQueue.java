package com.yw.datastructure.heap;

import java.util.Arrays;
import java.util.Queue;

public class PriorityQueue {
    int size = 0;
    int capacity = 16;
    int[] array;

    public PriorityQueue(){
        array = new int[capacity];
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(1);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(4);

        System.out.println(priorityQueue.deQueue());
        System.out.println(priorityQueue.deQueue());
        System.out.println(priorityQueue.deQueue());
    }

    public  void enQueue(int value){
        if(size == array.length){
            reSize();
        }
        array[size++] = value;
        upAdjust(array);
    }

    public int deQueue(){
        if(size == 0){
            throw new RuntimeException("无元素");
        }
        int temp = array[0];
        array[0] = array[--size];
        downAdjust(array,0);
        return temp;
    }

    public void reSize(){
        capacity <<= 1;
        array = Arrays.copyOf(array,capacity);
    }


    /**
     * 上浮调整
     *
     * @param array
     */
    public  void upAdjust(int[] array) {
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (childIndex > 0) {
            if (temp < array[parentIndex]) {
                array[childIndex] = array[parentIndex];
                childIndex = parentIndex;
                parentIndex = (parentIndex - 1) / 2;
            } else {
                break;
            }
        }
        array[childIndex] = temp;
    }

    /**
     * 下沉调整
     *
     * @param array
     * @param parentIndex
     */
    public  void downAdjust(int[] array, int parentIndex) {
        //左孩子
        int childIndex = 2 * parentIndex + 1;
        int temp = array[parentIndex];
        while (childIndex < size) {
            //右孩子小于左孩子时，定位到右孩子
            if (childIndex + 1 < array.length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            if (array[parentIndex] <= array[childIndex])
                break;
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

}

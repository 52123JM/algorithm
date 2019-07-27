package com.yw.datastructure.heap;

import javax.net.ssl.SSLEngine;
import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 6, 5, 8, 7, 1, 0};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 堆排序
     * @param array
     */
    public static void heapSort(int[] array){
        //构建堆
        buildHeap(array);
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length - 1; i++) {
            //删除第一个元素（将第一个元素换到后面）
            int temp = array[array.length - 1 - i];
            array[array.length - 1 - i] = array[0];
            array[0] = temp;
            //让第一个节点下沉
            downAdjust(array,0, array.length - 1 - i);
        }
    }

    /**
     * 构建堆
     * @param array
     */
    public static void buildHeap(int[] array) {
        //从最后一个非叶子节点开始，依次下沉调整
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }

    /**
     * 下浮调整
     * @param array
     * @param parentIndex
     * @param length 当前数组实际长度
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        //左孩子
        int childIndex = 2 * parentIndex + 1;
        int temp = array[parentIndex];
        while (childIndex < length) {
            //右孩子大于左孩子时，定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }

            if (temp >= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

}

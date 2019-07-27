package com.yw.datastructure.heap;

/**
 * 堆
 */
public class Heap {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 6, 5, 8, 7, 1, 0};
        upAdjust(array);
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
        buildHeap(array);
        for (int n : array) {
            System.out.print(n + " ");
        }
    }

    /**
     * 构建堆
     *
     * @param array
     */
    public static void buildHeap(int[] array) {
        //从最后一个非叶子节点开始，依次下沉调整
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i);
        }
    }

    /**
     * 上浮调整
     *
     * @param array
     */
    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
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
    public static void downAdjust(int[] array, int parentIndex) {
        //左孩子
        int childIndex = 2 * parentIndex + 1;
        int temp = array[parentIndex];
        while (childIndex < array.length) {
            //右孩子小于左孩子时，定位到右孩子
            if (childIndex + 1 < array.length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            if (array[parentIndex] <= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }
}

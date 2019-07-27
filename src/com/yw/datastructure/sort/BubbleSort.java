package com.yw.datastructure.sort;

import java.util.Arrays;

/**
 * 冒泡排序 优化版
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{9,8,1,2,3,4};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array){
        //记录最后一次交换位置，在它之后的元素都为有序，下次只需比较到这里
        int lastExchangeIndex = 0;
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            //记录当前一轮是否交换，若无交换则已有序
            boolean isExchanged = false;
            for (int j = 0; j < sortBorder; j++) {
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isExchanged = true;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if(!isExchanged){
                break;
            }
        }
    }

}

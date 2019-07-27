package com.yw.datastructure.sort;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountSort {
    public static void main(String[] args) {
        int[] array = new int[]{9,8,1,2,3,4};
        int[] sortedArray = sort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] sort(int[] array) {
        //找初最大最小值
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if(max < array[i]){
                max = array[i];
            }
            if(min > array[i]){
                min = array[i];
            }
        }

        int[] countArray = new int[max - min + 1];
        //统计对应元素个数
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }

        //计数数组变形，得到各元素名次，实现排序稳定性
        int sum = 0;
        for (int i = 0; i < countArray.length; i++) {
            sum += countArray[i];
            countArray[i] = sum;
        }

        //根据原始数组和计数数组得到有序数组
        int[] sortedArray = new int[array.length];
        for (int i = array.length - 1; i >= 0 ; i--) {
            int countArrayIndex = array[i] - min;
            sortedArray[countArray[countArrayIndex] - 1] = array[i];
            countArray[countArrayIndex]--;
        }

        return sortedArray;

    }
}

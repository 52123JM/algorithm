package com.yw;

import java.util.Arrays;

//找到一个数的离他最近的且大于它的交换数
public class NearestNumber {

    public static void main(String[] args) {
        int[] number = new int[]{1,2,3,5,4};
        NearestNumber nearestNumber = new NearestNumber();
        int[] result = nearestNumber.findNearestNumber(number);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }

    public int[] findNearestNumber(int[] number){
        //避免直接修改参数
        int[] numberCopy = Arrays.copyOf(number,number.length);
        //从最低位开始查找逆序区域，逆序区域的前一位即为数字交换的边界
        int index = findIndex(numberCopy);
        //如果index为-1，说明这个数已经为逆序（如54321），无法找到更大的数，返回自身
        if(index == -1){
            return number;
        }
        //将index与逆序区域中第一个大于index的数交换
        exchange(numberCopy,index);
        //将index之后的逆序的数变为正序
        reverse(numberCopy,index);
        return numberCopy;
    }


    public int findIndex(int[] number){
        for (int i = number.length - 1; i > 0; i--) {
            if(number[i - 1] < number[i]){
                return i -1;
            }
        }
        return -1;
    }

    private void exchange(int[] number, int index) {
        for (int i = number.length - 1; i > index; i--) {
            if(number[i] > number[index]) {
                int temp = number[i];
                number[number.length - 1] = number[index];
                number[index] = temp;
                break;
            }
        }

    }

    public void reverse(int[] number,int index){
        for(int i = index + 1,j = number.length - 1; i < j; i++,j--){
            int temp = number[j];
            number[j] = number[i];
            number[i] = temp;
        }
    }

}

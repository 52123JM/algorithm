package com.yw.bitwiseoperation;

//计算一个数的二进制数中1的个数
public class CountOf1 {

    public static void main(String[] args) {
        System.out.println(countOf1(5));
    }

    public static int countOf1(int number){
        int count = 0;
        while(number != 0){
            if((number & 1) == 1){
                count++;
            }
            number >>= 1;
        }
        return count;
    }
}

package com.yw.bitwiseoperation;

//判断一个数是否为2的乘方
public class IsPowerOf2 {

    public static void main(String[] args) {
        System.out.println(isPowerOf2(8));
    }

    public static boolean isPowerOf2(int number){
        return (number & number - 1) == 0; //2的乘方二进制都是最高位为1，其余为0，而其减一后所有位为1，相与为0
    }
}

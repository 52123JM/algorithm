package com.yw;

//大整数乘法
public class BigNumberMultiply {

    public static void main(String[] args) {
        Integer t = null;
        String s = "155555555555555555555555555555555555555555555555";
        for (int i = 1555555555; i <= 1555555556; i++) {
            t = i;
            String s1 = multiply(t.toString(),s);
            System.out.println(s1);
        }
    }

    public static String multiply(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int len = c1.length + c2.length;
        char[] c = new char[len];

        for (int i = 0; i < c.length; i++) {
            c[i] = '0';
        }

        for (int i = c1.length -1; i >= 0; i--) {
            int index = len - 1;
            int res = 0;
            for (int j = c2.length - 1; j >= 0; j--) {
                int tmp = (c1[i] - '0') * (c2[j] - '0') + (c[index] - '0') + res;
                c[index--] = (char)(tmp % 10 + '0');
                res = tmp/10;
            }

            c[index] = (char) (res + '0');
            len--;
        }

        String s = new String(c);
        if(s.charAt(0) == '0')
            return s.substring(1);
        else
            return s;
    }
}

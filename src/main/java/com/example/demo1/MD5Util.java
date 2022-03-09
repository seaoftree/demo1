package com.example.demo1;

import java.security.MessageDigest;

public class MD5Util {
    public static void main(String[] args) {
        String origin = MD5("销售类");
        System.out.println(origin);
        assert origin != null;
        System.out.println(JM(JM("4c96a2035e93b807d3a02e852e28beb7")));
    }
    public static String MD5(String key) {

        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * 加密后解密 运行一次为加密 再运行一次为解密
     * @param inStr
     * @return
     */
    public static String JM(String inStr) {
        byte[] a = inStr.getBytes();
        for(int i = 0 ; i < a.length ; i++) {
            a[i] = (byte) (a[i] ^ 't');

        }
        return new String(a);

    }
}


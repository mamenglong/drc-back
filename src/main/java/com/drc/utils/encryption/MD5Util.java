/*
  Created by IntelliJ IDEA.
  User: Long
  Date: 2018/10/29
  Time: 12:33
  To change this template use File | Settings | File Templates.
*/
package com.drc.utils.encryption;

import java.security.MessageDigest;

/**
 * 不可逆
 */
public class MD5Util{
    public static final String MD5 = "MD5";
    public static final String HmacMD5 = "HmacMD5";
    public static final String charset = null; // 编码格式；默认null为GBK

    private static MD5Util instance;

    private MD5Util() {
    }

    // 单例
    public static MD5Util getInstance() {
        if (instance == null) {
            synchronized (MD5Util.class) {
                if (instance == null) {
                    instance = new MD5Util();
                }
            }
        }
        return instance;
    }

    public static void main(String[] a){
        System.out.println(MD5Util.getInstance().encode("123456"));
        System.out.println(MD5Util.getInstance().encode("123456"));
    }
    /**
     * 使用 MD5 方法加密（无密码）
     */
    public String encode(String pwd) {
        //用于加密的字符
        char md5String[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            //使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中
            byte[] btInput = pwd.getBytes();

            //信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。
            MessageDigest mdInst = MessageDigest.getInstance("MD5");

            //MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要
            mdInst.update(btInput);

            // 摘要更新之后，通过调用digest（）执行哈希计算，获得密文
            byte[] md = mdInst.digest();

            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {   //  i = 0
                byte byte0 = md[i];  //95
                str[k++] = md5String[byte0 >>> 4 & 0xf];    //    5
                str[k++] = md5String[byte0 & 0xf];   //   F
            }

            //返回经过加密后的字符串
            return new String(str);

        } catch (Exception e) {
            return null;
        }
    }
}
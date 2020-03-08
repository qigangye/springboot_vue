package com.cscrb.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Classname SHAPwd
 * @Description 密码加密工具类
 * @Date 2020/3/5 8:59
 */
public class SHAPwd {

    private static final String KEY = "asdfqwer1234a1s2sd3";
    public static String signature(String inStr) {
        MessageDigest md = null;
        String outStr = null;
        try {
            inStr = MD5.signature(inStr + KEY);
            md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(inStr.getBytes());
            outStr = bytetoString(digest);
        } catch (NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }
        return outStr;
    }

    public static String bytetoString(byte[] digest) {
        String str = "";
        String tempStr = "";

        for (int i = 1; i < digest.length; i++) {
            tempStr = (Integer.toHexString(digest[i] & 0xff));
            if (tempStr.length() == 1) {
                str = str + "0" + tempStr;
            } else {
                str = str + tempStr;
            }
        }
        return str.toLowerCase();
    }
}

package com.lzh.commonframe.common.util;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * MD5加密
 * @author Administrator
 *
 */
public class Md5Utils {

    private static final Logger LOGGER = LoggerFactory.getLogger(Md5Utils.class);


    private static byte[] md5(String s) {
        MessageDigest algorithm;
        try {
            algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(s.getBytes("UTF-8"));
            byte[] messageDigest = algorithm.digest();
            return messageDigest;
        } catch (Exception e) {
            LOGGER.error("MD5 Error...", e);
        }
        return null;
    }

    private static final String toHex(byte hash[]) {
        if (hash == null) {
            return null;
        }
        StringBuffer buf = new StringBuffer();
        int i;
        for (i = 0; i < hash.length; i++) {
            if (Integer.toHexString(0xFF & hash[i]).length() == 1)
                buf.append("0").append(Integer.toHexString(0xFF & hash[i]));
            else
                buf.append(Integer.toHexString(0xFF & hash[i]));

        }
        return buf.toString();
    }

    public static String hash(String s) {
        try {
            return new String(toHex(md5(s)).getBytes("UTF-8"), "UTF-8");
        } catch (Exception e) {
            LOGGER.error("not supported charset...{}", e);
            return s;
        }
    }

    /**
     * 对密码按照用户名，密码，盐进行加密
     * @param username 用户名
     * @param password 密码
     * @param salt 盐
     * @return
     */
    public static String encryptPassword(String username, String password, String salt) {
        return Md5Utils.hash(username + password + salt);
    }

    /**
     * 对密码按照密码，盐进行加密
     * @param password 密码
     * @param salt 盐
     * @return
     */
    public static String encryptPassword(String password, String salt) {
        return Md5Utils.hash(password + salt);
    }

}

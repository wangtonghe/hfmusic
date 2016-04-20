package top.wthfeng.hfmusic.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * Created by Administrator on 2016/1/1.
 */
public class MD5Util {
    public static final String ENCODING_VALUE = "UTF-8";
    public static String string2MD5(String string) {

        if (null == string) {
            return null;
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        byte[] byteArray = null;
        StringBuilder hexValue = new StringBuilder();
        try {
            byteArray = string.getBytes(ENCODING_VALUE);
            byte[] md5Bytes = md5.digest(byteArray);

            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }
        } catch (UnsupportedEncodingException e) {

            return "";
        }

        return hexValue.toString();
    }


}

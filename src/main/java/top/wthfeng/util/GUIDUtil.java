package top.wthfeng.util;

import java.util.UUID;

/**
 * Created by Administrator on 2016/1/1.
 */
public class GUIDUtil {
    /**
     * 返回标准带横线的guid
     * @return
     */
    public static String standardGUID(){
        return UUID.randomUUID().toString();
    }
    /**
     * 返回没有横线的guid
     * @return
     */
    public static String normalGUID(){
        String standardUUID = UUID.randomUUID().toString();
        StringBuilder sb = new StringBuilder();
        char c = '-';
        for (int i = 0; i < standardUUID.length(); i++) {
            char ch = standardUUID.charAt(i);
            if (ch != c) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

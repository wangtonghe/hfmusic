package com.wthfeng.hfmusic.util;

import net.sf.json.JSONObject;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具
 * @author 作者： zhanghaiwei
 * @version 1.0
 * @date 创建时间：2015/7/3 16:04
 * @since jdk1.6.0_27
 */
public class StringUtil {


    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if(str == null || str.trim().length() == 0){
            return true;
        }
        return false;
    }

    private static final String PHONE_NUM_REG = "((13[0-9])|(15[^4,\\D])|(18[0-9]))(\\D*\\d){8}";
    private static final String TELL_NUM_REG = "((\\(\\d{3,4}\\))|(\\d{3,4}-?))(\\D*\\d){7,8}";

    /**
     * 判断字符串是否包含手机号
     * @param targetstr
     * @return
     */
    public static boolean containsPhoneNum(String targetstr){
        Pattern p = Pattern.compile(PHONE_NUM_REG);
        Matcher matcher = p.matcher(targetstr);
        return matcher.find();
    }

    /**
     * 判断字符串是否包含电话号码
     * @param targetstr
     * @return
     */
    public static boolean containsTellNum(String targetstr){
        Pattern p = Pattern.compile(TELL_NUM_REG);
        Matcher matcher = p.matcher(targetstr);
        return matcher.find();
    }

    /**
     * 是否是指定长度的字符串
     * @param str
     * @param length
     * @return
     */
    public static boolean isNumStr(String str,int length){
        if(StringUtil.isEmpty(str)){
            return false;
        }
        Pattern p = Pattern.compile("\\d{"+length+"}");
        Matcher matcher = p.matcher(str);
        return matcher.matches();
    }

    /**
     * 将map转换为json数据
     * @param map
     * @return
     */
    public static String map2Json(Map map){
        JSONObject jo = JSONObject.fromObject(map);
        return jo.toString();
    }
}

package com.stone.tree.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dbw
 * @date 2021/01/08/6:03 下午
 * @Description
 */
public class DateUtil {

    public static final String FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * 今天日期String
     * @param format
     * @return
     */
    public static String nowDateToString(String format){
        Date date =new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try{
            return dateFormat.format(date);
        }catch(Exception ex){
            ex.printStackTrace();
            return "";
        }
    }

    /**
     * 今天日期long
     * @param format
     * @return
     */
    public static Long nowDateToLong(String format){
        Date date =new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try{
            return Long.valueOf(dateFormat.format(date));
        }catch(Exception ex){
            ex.printStackTrace();
            return 0L;
        }
    }
}

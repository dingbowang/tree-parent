package com.stone.tree.util;

import java.util.UUID;

/**
 * @author dbw
 * @date 2021/01/02/9:26 下午
 * @Description
 */
public class UUIDUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}

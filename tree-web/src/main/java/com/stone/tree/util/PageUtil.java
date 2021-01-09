package com.stone.tree.util;

import com.github.pagehelper.PageInfo;
import com.stone.tree.response.PageResult;

/**
 * @author dbw
 * @date 2021/01/09/1:33 下午
 * @Description
 */
public class PageUtil {

    public static PageResult pageReturn(PageInfo<?> pageInfo){
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}

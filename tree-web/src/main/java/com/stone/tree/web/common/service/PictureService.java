package com.stone.tree.web.common.service;

import com.stone.tree.response.PageResult;
import com.stone.tree.web.common.bean.Picture;

import java.util.List;

/**
 * (Picture)表服务接口
 *
 * @author makejava
 * @since 2021-01-10 13:50:03
 */
public interface PictureService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Picture selectById(String id);

    /**
     * 查询多条数据(分页)
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    PageResult selectPage(int offset, int limit);
    
    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    public List<Picture> selectAll();

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    public List<Picture> selectList(Picture picture) ;
    
    /**
     * 新增数据
     *
     * @param picture 实例对象
     * @return 实例对象
     */
    public int insert(Picture picture);

    /**
     * 批量新增
     *
     * @param pictures 实例对象的集合
     * @return 生效的条数
     */
    public int batchInsert(List<Picture> pictures) ;

    /**
     * 修改数据
     *
     * @param picture 实例对象
     * @return 实例对象
     */
    public Picture update(Picture picture) ;

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public int deleteById(String id) ;
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     public int count();
}
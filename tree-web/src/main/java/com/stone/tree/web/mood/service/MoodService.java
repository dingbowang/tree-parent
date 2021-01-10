package com.stone.tree.web.mood.service;

import com.stone.tree.response.PageResult;
import com.stone.tree.web.mood.bean.Mood;

import java.util.List;

/**
 * (Mood)表服务接口
 *
 * @author makejava
 * @since 2021-01-10 13:49:42
 */
public interface MoodService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Mood selectById(String id);

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
    public List<Mood> selectAll();

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    public List<Mood> selectList(Mood mood) ;
    
    /**
     * 新增数据
     *
     * @param mood 实例对象
     * @return 实例对象
     */
    public int insert(Mood mood);

    /**
     * 批量新增
     *
     * @param moods 实例对象的集合
     * @return 生效的条数
     */
    public int batchInsert(List<Mood> moods) ;

    /**
     * 修改数据
     *
     * @param mood 实例对象
     * @return 实例对象
     */
    public Mood update(Mood mood) ;

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
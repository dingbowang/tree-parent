package com.stone.tree.web.mood.mapper;

import com.stone.tree.web.mood.bean.Mood;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Mood)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-10 13:49:42
 */
@Mapper
public interface MoodMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Mood selectById(String id);
	
    /**
     * 分页查询
     *
     * @return 对象列表
     */
    List<Mood> selectPage();

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<Mood> selectAll();
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param mood 实例对象
     * @return 对象列表
     */
    List<Mood> selectList(Mood mood);

    /**
     * 新增数据
     *
     * @param mood 实例对象
     * @return 影响行数
     */
    int insert(Mood mood);
    
     /**
     * 必填项新增数据
     *
     * @param mood 实例对象
     * @return 影响行数
     */
    int insertSelective(Mood mood);
	
	/**
     * 批量新增
     *
     * @param moods 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Mood> moods);
	
    /**
     * 修改数据
     *
     * @param mood 实例对象
     * @return 影响行数
     */
    int update(Mood mood);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();
}
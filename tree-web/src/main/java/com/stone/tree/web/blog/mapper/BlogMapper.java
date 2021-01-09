package com.stone.tree.web.blog.mapper;

import com.stone.tree.web.blog.bean.Blog;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * (Blog)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-09 14:04:07
 */
public interface BlogMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Blog selectById(String id);
	
    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Blog> selectPage();

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<Blog> selectAll();
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param blog 实例对象
     * @return 对象列表
     */
    List<Blog> selectList(Blog blog);

    /**
     * 新增数据
     *
     * @param blog 实例对象
     * @return 影响行数
     */
    int insert(Blog blog);
    
     /**
     * 必填项新增数据
     *
     * @param blog 实例对象
     * @return 影响行数
     */
    int insertSelective(Blog blog);
	
	/**
     * 批量新增
     *
     * @param blogs 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Blog> blogs);
	
    /**
     * 修改数据
     *
     * @param blog 实例对象
     * @return 影响行数
     */
    int update(Blog blog);

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
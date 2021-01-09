package com.stone.tree.web.comment.mapper;

import com.stone.tree.web.comment.bean.BlogComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BlogComment)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-09 10:00:05
 */
public interface BlogCommentMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogComment selectById(String id);
	
    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BlogComment> selectPage(@Param("start") int start, @Param("limit") int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<BlogComment> selectAll();
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param blogComment 实例对象
     * @return 对象列表
     */
    List<BlogComment> selectList(BlogComment blogComment);

    /**
     * 新增数据
     *
     * @param blogComment 实例对象
     * @return 影响行数
     */
    int insert(BlogComment blogComment);
    
     /**
     * 必填项新增数据
     *
     * @param blogComment 实例对象
     * @return 影响行数
     */
    int insertSelective(BlogComment blogComment);
	
	/**
     * 批量新增
     *
     * @param blogComments 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<BlogComment> blogComments);
	
    /**
     * 修改数据
     *
     * @param blogComment 实例对象
     * @return 影响行数
     */
    int update(BlogComment blogComment);

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
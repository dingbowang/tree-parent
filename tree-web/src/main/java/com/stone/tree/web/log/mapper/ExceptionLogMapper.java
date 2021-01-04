package com.stone.tree.web.log.mapper;

import com.stone.tree.web.log.bean.ExceptionLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (ExceptionLog)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-03 14:34:13
 */
@Mapper
public interface ExceptionLogMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param excId 主键
     * @return 实例对象
     */
    ExceptionLog selectById(String excId);
	
    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ExceptionLog> selectPage(@Param("start") int start, @Param("limit") int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<ExceptionLog> selectAll();
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param exceptionLog 实例对象
     * @return 对象列表
     */
    List<ExceptionLog> selectList(ExceptionLog exceptionLog);

    /**
     * 新增数据
     *
     * @param exceptionLog 实例对象
     * @return 影响行数
     */
    int insert(ExceptionLog exceptionLog);
	
	/**
     * 批量新增
     *
     * @param exceptionLogs 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<ExceptionLog> exceptionLogs);
	
    /**
     * 修改数据
     *
     * @param exceptionLog 实例对象
     * @return 影响行数
     */
    int update(ExceptionLog exceptionLog);

    /**
     * 通过主键删除数据
     *
     * @param excId 主键
     * @return 影响行数
     */
    int deleteById(String excId);

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();
}
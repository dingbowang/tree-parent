package com.stone.tree.web.log.mapper;

import com.stone.tree.web.log.bean.ExceptionLog;

import java.util.List;

/**
 * (ExceptionLog)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-09 14:09:16
 */
public interface ExceptionLogMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ExceptionLog selectById(String id);
	
    /**
     * 分页查询
     *
     * @return 对象列表
     */
    List<ExceptionLog> selectPage();

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
     * 必填项新增数据
     *
     * @param exceptionLog 实例对象
     * @return 影响行数
     */
    int insertSelective(ExceptionLog exceptionLog);
	
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
package com.stone.tree.web.log.service;

import com.stone.tree.web.log.bean.ExceptionLog;

import java.util.List;

/**
 * (ExceptionLog)表服务接口
 *
 * @author makejava
 * @since 2021-01-03 14:34:13
 */
public interface ExceptionLogService {

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
    List<ExceptionLog> selectPage(int start, int limit);

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
     * @return 修改
     */
    ExceptionLog update(ExceptionLog exceptionLog);

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